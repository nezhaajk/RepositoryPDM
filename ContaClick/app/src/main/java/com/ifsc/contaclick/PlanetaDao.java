package com.ifsc.contaclick;

import java.util.ArrayList;

public class PlanetaDao {
    public PlanetaDao() {
        this.planetas=new ArrayList<>();
        String [] nomes= new String[]{"Mercurio", "Venus", "Terra", "Marte", "Jupter", "Saturno", "Urano", "Netuno"};
        Integer[] imagens=new Integer[]{R.drawable.mercury,R.drawable.venus,
                                        R.drawable.earth,R.drawable.mars,
                                        R.drawable.jupter,R.drawable.saturn,
                                        R.drawable.uranus,R.drawable.neptune,}    ;
        for (int i=0; i< nomes.length; i++){
            plametas.add(new Planeta(nomes[1],imagens[1]));
        }
    }

    public ArrayList<Planeta> getPlanetas(){
        return new ArrayList<>();
    }
}
