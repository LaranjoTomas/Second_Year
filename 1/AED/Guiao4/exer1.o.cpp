#include<iostream>

int main(void) {
    std::cout << "Escreve um numero" << std::endl;
    int x;
    std::cin>>x;
    for(int i=1;i<=x;i++){ 
        std::cout << "Escreveste: " << i <<std::endl;    
    }
    return 0;
}

