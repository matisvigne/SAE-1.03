public class Joueur {
    private String nom;     // le nom du joueur
    private MEE chevalet;   // le chevalet du joueur
    private int score;      // le score du joueur

    public Joueur(String unNom){
        /* Constructeur */
        this.nom = unNom;
    }

    public String toString(){
        /* affiche les caractéristiques du joueur */
        return "Le joueur " + nom + " possède un score de " + score + ".";
    }

    public int getScore(){
        /* résultat : renvoie le score de this */
        return this.score;
    }

    public void ajouteScore(int nb){
        /* résultat : ajoute nb au score de this */
        this.score += nb;
    }

    public int nbPointsChevalet(int[] nbPointsJet){
        /* pré-requis : nbPointsJet indique le nombre de points rapportés par chaque jeton/lettre
           résultat : le nombre de points total sur le chevalet de ce joueur */
       return this.chevalet.sommeValeurs(nbPointsJet);
       // La fonction "sommeValeurs" appartient à la classe MEE
    }

    public void prendJetons(MEE s, int nbJetons){
        /* pré-requis : les éléments de s sont inférieurs à 26
           action : simule la prise de nbJetons par this dans le sac s, dans la limite de son contenu */
        s.transfereAleat(this.chevalet, nbJetons);
    }

    public int joue(Plateau p, MEE s, int[] nbPointsJet){
        /* pré-requis : les éléments de s sont inférieurs à 26 et nbPointsJet.length >= 26
            action : simule le coup de this : this choisit de passer son tour, d'échanger des jetons ou de placer un mot
            résultat : -1 si this a passé son tour, 1 si son chevalet est vide et 0 sinon */
        int resultat = 0;
        Ut.afficher("Que souhaitez vous faire ? \n1. Je passe mon tour.\n2. J'échange des jetons\n3. Je place un mot.");
        int choix = Ut.saisirEntier();
        if(choix == 1){
            resultat = -1;
        }else if(choix == 2){
            this.prendJetons(s, 1);
            
        }else if(choix == 3){

        }
        return resultat;
    }

    public boolean joueMot(Plateau p, MEE s, int[] nbPointsJet){
        /** pré-requis : les éléments de s sont inférieurs à 26
                         et nbPointsJet.length >= 26
            action : simule le placement d’un mot de this :
                    a) le mot, sa position sur le plateau et sa direction, sont saisis au clavier
                    b) vérifie si le mot est valide
                    c) si le coup est valide, le mot est placé sur le plateau
            résultat : vrai ssi ce coup est valide, c’est-à-dire accepté par
                       CapeloDico et satisfaisant les règles détaillées plus haut
            stratégie : utilise la méthode joueMotAux */
        
    }

    public void joueMotAux(Plateau p, MEE s, int[] nbPointsJet, String mot, int numLig, int numCol, char sens){
        /* pré-requis : cf. joueMot et le placement de mot à partir de la case (numLig, numCol) dans le sens donné par sens est valide
           action : simule le placement d'un mot de this */
        for(int i = 0; i < mot.length(); i++){
            if(sens == 'h' && p.placementValide(mot, numLig, numCol, sens, s)){
                p[numLig + i][numCol] = mot.charAt(i);
                nbPointsJet
            }else if(sens == 'v' && p.placementValide(mot, numLig, numCol, sens, s)){
                p[numLig][numCol + i] = mot.charAt(i);
            }
        }
        // il manque l'incrémentation du nbPointsJet et le remplissage du chevalet pour qu'il possède 7 jetons as expected.
    }
}
