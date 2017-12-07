
import java.lang.reflect.Array;
import java.util.Arrays;


 
public class Unidad6AMD {

    //constructor
    String [] arreglo;
    int tamanio,contador;
    public Unidad6AMD( int tam){
        tamanio=tam;
        arreglo=new String[tam];
        Arrays.fill(arreglo,"-1");
        
    }

    /**
     *
     * @param cadenaArreglo
     * @param arreglo
     */
    public void funcionhash(String[] cadenaArreglo,String[] arreglo){
        int i;
        for(i=0;i<cadenaArreglo.length;i++){
            String elemento=cadenaArreglo[i];
            int indiceArreglo=Integer.parseInt(elemento)%7;
            System.out.println(" el indice es "+ indiceArreglo+"  para el elemnto "+ elemento);
            
            // tratando las colisiones
            while( arreglo[indiceArreglo]!="-1"){
                indiceArreglo++;
                System.out.println("  ocurrio una colision ene l indice"+(indiceArreglo-1)+" cambiar al indice"+ indiceArreglo);
                
                indiceArreglo%=tamanio;
                
                
            }
            arreglo[indiceArreglo]=elemento;
            
            
        }
        
    }
    // metodo para mostrar la tabla
    public void mostar(){
        int incremento = 0,i,j;
        for(i=0; i < 1; i++){
            incremento +=8;
            for(j=0; j<71; j++){
                System.out.println("_");
                
            }
            System.out.println();
            for(j=incremento-8;j<incremento;j++){
                System.out.format("| %3s"+"",j);
                
            }
            System.out.println("|");
            for (int n=0; n < 71; n++){
                 System.out.println("_");
            }
            System.out.println();
            for(j= incremento -8; j< incremento;j++){
                if (arreglo[j].equals("-1")){
                    System.out.print(" |        ");
                    
                }else{
                    System.out.print(String.format("| %3s"+"", arreglo[j]));
                    
                }
                
            }
             System.out.println("|");
             for(j=0; j< 71; j++){
                  System.out.print("-");
             }
              System.out.println();
        }
    }
    // metodo para buscar clave 
    public String buscarclave(String elemento){
        int indiceArreglo=Integer.parseInt(elemento)%7;
        int contador=0;
        
        while(arreglo[indiceArreglo]!="-1"){
            if(arreglo [indiceArreglo] == elemento){
                
                System.out.println("  el elemento "+ elemento+" fue encontradoen el indice"+indiceArreglo);
                
                
                return arreglo[indiceArreglo];
                
                
            }
            indiceArreglo++;
            indiceArreglo%=tamanio;
            contador++;
            if( contador>7){
                
                break;
                
            }
            
        }
        return null;
    }
    public static void main(String[] args) {
        Unidad6AMD hash=new Unidad6AMD(8);
        String[] elementos={ "20","33","21","10","12","14","56","100"};
        hash.funcionhash(elementos, hash.arreglo);
        hash.mostar();
        String buscado=hash.buscarclave("33");
        if( buscado==null){
             System.out.println("   el elemento 33 no se encuentra en la tabla" );
            
            
        }
        
    }
    
    
    
}
