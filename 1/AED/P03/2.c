#define SIZE 3
void main(void) 
{
 static char *array[SIZE]={"Array", "de", "ponteiros"};
 char **p;
 char **pultimo;
 p = array;
 pultimo = array + SIZE;
 for(; p < pultimo; p++)
 {
 print_string(*p);
 print_char('\n');
 }
} 
