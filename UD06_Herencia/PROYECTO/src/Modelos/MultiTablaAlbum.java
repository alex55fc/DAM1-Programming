package Modelos;


public class MultiTablaAlbum {
    
    private String tituloAlbum;
    private int anioPublicacionAlbum;
    private String tituloCancion;
    private String duracionCancion;

    public MultiTablaAlbum(String tituloAlbum, int anioPublicacionAlbum, String tituloCancion, String duracionCancion){
        this.tituloAlbum = tituloAlbum;
        this.anioPublicacionAlbum = anioPublicacionAlbum;
        this.tituloCancion = tituloCancion;
        this.duracionCancion = duracionCancion;
    }

    public int getAnioPublicacionAlbum() {
        return anioPublicacionAlbum;
    }

    public String getTituloAlbum() {
        return tituloAlbum;
    }

    public String getTituloCancion() {
        return tituloCancion;
    }

    public String getDuracionCancion() {
        return duracionCancion;
    }

    

    @Override
    public String toString() {
        return "MultiTablaCancion [Album=" + tituloAlbum + ", FechaAlbum=" + anioPublicacionAlbum
                + ", Cancion=" + tituloCancion + ", DuracionCancion=" + duracionCancion + "]";
    }

    
    
}
