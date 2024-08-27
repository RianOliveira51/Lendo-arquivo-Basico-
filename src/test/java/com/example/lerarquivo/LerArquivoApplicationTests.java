package com.example.lerarquivo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

@SpringBootTest
class LerArquivoApplicationTests {

    public static void main(String[] args) throws FileNotFoundException {
        //Instanciando o arquivo com o caminho.
        File arquivo = new File("C:\\temp\\in.txt");
        Scanner sc = null;

        //ao tentar ler o arquivo o programa pode dar uma IOException, por isso colocamos já tratamos.
        try {
            //Instanciando o Scanner apartir do arquivo criado.
            sc = new Scanner(arquivo);
            //testando para saber se ainda tem linhas para ler no arquivo, se tiver imprimir a linha.
            while(sc.hasNextLine()){
                System.out.println(sc.nextLine());
            }
        }catch(IOException e ){
            System.out.println("Error: " + e.getMessage());
        }
        /*Boas praticas: colocar o fechamento dos seus recuros no bloco finall, pois o recurso vai ser fechado
        * independente se deu certo ou não o try */

        finally {
            //caso o Scanner não for iniciado e já deu uma excessão, sendo assim o valor do sc vai ser null.
            if(sc != null) {
                sc.close();
            }
        }
    }

}
