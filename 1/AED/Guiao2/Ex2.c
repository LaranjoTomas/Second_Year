//
// Tomás Oliveira e Silva, AED, October 2021
//
// list all command line arguments
//

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int IsInteger(char *token){
    for (size_t i = 0; i < strlen(token); i++){
        if (token[i] < '0' || token[i] > '9'){
            return 0;
        }
    }
    return 1;
}



int main(int argc,char *argv[argc])
{
    for(size_t i = 0;i < argc;i++){
        char *token = argv[i];
        if (IsInteger(token)){
            printf("argv[%2lld] = \"%s\" integer value: %ld\n",i,token,atol(token));
        }
        else{
            printf("argv[%2lld] = \"%s\"\n",i,token);
        }
    }
    return 0;
}