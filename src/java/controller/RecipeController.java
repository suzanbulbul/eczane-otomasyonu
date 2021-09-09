package controller;

import entity.*;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author gurkangltekin
 * 
 * bu sinifimiz, recete nesnemizin ve veritabanindaki recete verilerini arayuzde
 * goruleyebilmemiz icin nesne ve arayuz arasinda haberlesme ve kontrol gorevi goruyor.
 */
@Named
@SessionScoped
public class RecipeController extends Controller implements Serializable {
    
    private List<medicine> medicines;
    
    public void deleteConfirmdetail(){
        
    }
    
    public String detail(recipe recipe){
        this.setRecipe(recipe);
        return "/secret/recipe_detail";
    }
    
    @Override
    public void clearForm(){
        this.setRecipe(new recipe());
        this.setSelectedMedicines(null);
    }
    
    @Override
    public void update(){
        this.getRecipeDao().update(this.getRecipe());
        this.getRecipeDao().createRecipeMedicine(this.getSelectedMedicines(), this.getRecipe().getId(), this.getRecipe().getSick());
        this.setSelectedMedicines(null);
        this.setRecipe(new recipe());
    }
    
    @Override
    public void updateForm(Object obj){
        recipe recipe = (recipe)obj;
        this.setSelectedMedicines(this.getRecipeDao().getRecipeMedicines(recipe.getId()));
        this.setRecipe(recipe);
    }
    
    @Override
    public void deleteConfirm(Object obj){
        recipe recipe = (recipe)obj;
        this.setRecipe(recipe);
    }
    
    @Override
    public void delete(){
        this.getRecipeDao().delete(this.getRecipe());
        this.setRecipe(new recipe());
    }
    
    @Override
    public void create(){
        this.getRecipeDao().insert(this.getRecipe());
        this.getRecipeDao().createRecipeMedicine(this.getSelectedMedicines(),0, this.getRecipe().getSick());
        this.setSelectedMedicines(null);
        this.setRecipe(new recipe());
    }

    public List<medicine> getMedicines() {
        return medicines;
    }

    public void setMedicines(List<medicine> medicines) {
        this.medicines = medicines;
    }
    
    
}
