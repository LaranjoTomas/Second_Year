#include <detpic32.h>

volatile int value = 0;

void delay(unsigned int ms){
    resetCoreTimer();
    while(readCoreTimer() < (20000 * ms));
}

char getc (void) {
    while(U2STAbits.URXDA == 0);
    return U2RXREG;
}


void send2displays(unsigned char value) {
    static const char display7Scodes[] = {0x3F, 0x06, 0x5B, 0x4F, 0x66, 0x6D, 0x7D, 0x07, 0x7F, 0x6F, 0x77, 0x7C, 0x39, 0x5E, 0x79, 0x71};
    static char displayFlag = 0;

    int digit_low = value & 0x0F;
    int digit_high = value >> 4;

    if (displayFlag == 0) {
        LATDbits.LATD5 = 1; 
        LATDbits.LATD6 = 0;
        LATB = (LATB & 0x00FF) | (display7Scodes[digit_low] << 8);
    } else {
        LATDbits.LATD5 = 0;
        LATDbits.LATD6 = 1;
        LATB = (LATB & 0x00FF) | (display7Scodes[digit_high] << 8);
    }
    displayFlag = !displayFlag;
}


int main(void) {
    char C;

    // k_pres = 1,2,4,8,16,32,64,256
    //          0,1,2,3,4 ,5 ,6, 7

    // Configure Timer T2 (2 Hz with interrupts disabled)
    T2CONbits.TCKPS = 2; // / 20*10^6 / 65536 * 100 = 3
    PR2 = 49999; // Fout = 20MHz / (4) =  5000000 / 100 =  50000 
    TMR2 = 0; // Reset timer T2 count register
    T2CONbits.TON = 1; // Enable timer T2 (must be the last command of the timer configuration sequence)
    
    IPC2bits.T2IP = 2; // Interrupt priority (must be in range [1..6])
    IEC0bits.T2IE = 1; // Enable timer T2 interrupts

    TRISD = TRISD & 0xFF9F;
    LATD  = LATD & 0x0000;
    TRISE = TRISE & 0XFFF0;
    LATE  = LATE & 0x0000;
    TRISB = TRISB & 0X80FF; 

    EnableInterrupts(); // Global Interrupt Enable

    while(1) {
        C = getc();
    
        if (C == '0') {
            LATE = 0x0001;
            value = 0;
        } else if (C == '1') {
            LATE = 0x0002;
            value = 1;
        } else if (C == '2') {
            LATE = 0x0004;
            value = 2;
        } else if (C == '3') {
            LATE = 0x0008;
            value = 3;
        } else {
            value = 0xFF;
            LATE = 0x000F;
            delay(1000);
            LATE = 0x0000;
        }
    }
    return 0;
}

void _int_(8) isr_T2(void) {
    send2displays(value);
}