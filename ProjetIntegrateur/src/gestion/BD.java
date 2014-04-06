package gestion;

public class BD{
    
    private static volatile BD instance = null;
    private final static GestionnaireID gestionnaire = GestionnaireID.getInstance();
    
    MultiMap<Integer, String, Double> listeComposante;
    
    private BD() {
        listeComposante = new MultiMap<>();
    }
    
    public void setComposante(int ID, String info, double donne) {
        listeComposante.put(ID, info, donne);
        gestionnaire.ajouterComp(ID);
    }
    
    public boolean supprimerComposante(int ID) {
        if(gestionnaire.supprimerComp(ID)) {
            listeComposante.removeID(ID);
            return true;
        }
        return false;
    }
    
    public Double getComposante(int ID, String info) {
        return listeComposante.get(ID, info);
    }
    
    public void resetCircuit() {
        gestionnaire.resetCircuit();
        listeComposante.clear();
    }
    
    public final static BD getInstance() {
        if(BD.instance == null) {
            synchronized(BD.class) {
                if(BD.instance == null) {
                    BD.instance = new BD();
                }
            }
        }
        return BD.instance;
    }
}