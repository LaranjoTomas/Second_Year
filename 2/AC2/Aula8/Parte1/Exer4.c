#include <detpic32.h>
int main(void) {
    T1CONbits.TCKPS = 6;
    T3CONbits.TCKPS = 4;
    PR1 = 62499; // 5 Hz
    PR3 = 62499; // 25 Hz
    TMR1 = 0;
    TMR3 = 0; // Clear timer T3 count register
    T3CONbits.TON = 1; // Enable timer T3 (must be the last command of the
    // timer configuration sequence)
    IPC3bits.T3IP = 2; // Interrupt priority (must be in range [1..6])
    IEC0bits.T3IE = 1; // Enable timer T3 interrupts

    T1CONbits.TON = 1; // Enable timer T1 (must be the last command of the
    // timer configuration sequence)
    IPC1bits.T1IP = 2; // Interrupt priority (must be in range [1..6])
    IEC0bits.T1IE = 1; // Enable timer T1 interrupts

    EnableInterrupts();
    while(1);
    return 0;
}


void _int_(4) isr_T1(void) {
    static int i = 0;
    i++;
    if (i == 2) {
        putChar('b');
        i=0;
    } 
    // Reset T1 interrupt flag
    IFS0bits.T1IF = 0; // Reset T1 interrupt flag
}

void _int_(12) isr_T3(void) // Replace VECTOR by the timer T3
{
    static int i = 0;
    i++;
    if (i == 2) {
        putChar('a');
        i=0;
    } 
    
    // Reset T3 interrupt flag
    IFS0bits.T3IF = 0; // Reset T3 interrupt flag
}
