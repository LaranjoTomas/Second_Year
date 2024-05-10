#define SIZE 5 
void main(void)
{
 static int lista[SIZE]; // declara um array de inteiros
 // residente no segmento de dados
 static char str[]="\nIntroduza um numero: ";
 int i;
 for(i=0; i < SIZE; i++)
 {
 print_string(str);
 lista[i] = read_int();
 }
} 