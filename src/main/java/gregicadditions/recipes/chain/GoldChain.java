package gregicadditions.recipes.chain;

import gregtech.api.recipes.ModHandler;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import gregtech.api.unification.OreDictUnifier;

import static gregicadditions.GAMaterials.*;
import static gregicadditions.recipes.GARecipeMaps.CHEMICAL_DEHYDRATOR_RECIPES;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;

public class GoldChain {

    public static void init() {
        //GOLD process

        ModHandler.addSmeltingRecipe(OreDictUnifier.get(ingot, PreciousMetal), OreDictUnifier.get(nugget, Gold));
        ModHandler.addSmeltingRecipe(OreDictUnifier.get(dust, GoldLeach), OreDictUnifier.get(nugget, Gold, 2));

        ALLOY_SMELTER_RECIPES.recipeBuilder().EUt(120).duration(100)
                .input(dust, PreciousMetal)
                .input(dust, Copper, 3)
                .outputs(OreDictUnifier.get(ingot, GoldAlloy, 4))
                .buildAndRegister();


        CHEMICAL_RECIPES.recipeBuilder().duration(80)
                .input(ingot, GoldAlloy, 4)
                .fluidInputs(NitricAcid.getFluid(14000))
                .outputs(OreDictUnifier.get(dust, GoldLeach, 4))
                .fluidOutputs(NitrogenDioxide.getFluid(7000))
                .fluidOutputs(PreciousLeachNitrate.getFluid(7000))
                .buildAndRegister();

        CHEMICAL_RECIPES.recipeBuilder().duration(80)
                .input(dust, GoldLeach, 4)
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .fluidInputs(AquaRegia.getFluid(3000))
                .chancedOutput(LeadSulfate.getItemStack(), 1000, 0)
                .fluidOutputs(ChloroauricAcid.getFluid(1000))
                .fluidOutputs(NitrogenDioxide.getFluid(1000))
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder().duration(80).EUt(30)
                .notConsumable(new IntCircuitIngredient(1))
                .input(dust, Potassium, 2)
                .input(dust, Sulfur, 2)
                .fluidInputs(Oxygen.getFluid(5000))
                .outputs(OreDictUnifier.get(dust, PotassiumMetabisulfite, 9))
                .buildAndRegister();

        CHEMICAL_RECIPES.recipeBuilder().duration(100)
                .input(dust, PotassiumMetabisulfite)
                .fluidInputs(ChloroauricAcid.getFluid(10000))
                .fluidInputs(Water.getFluid(1000))
                .outputs(OreDictUnifier.get(dust, Gold, 9))
                .fluidOutputs(SulfurDioxide.getFluid(1000))
                .fluidOutputs(HydrochloricAcid.getFluid(1000))
                .buildAndRegister();

        CHEMICAL_RECIPES.recipeBuilder().duration(100)
                .fluidInputs(HydrochloricAcid.getFluid(4000))
                .fluidInputs(PreciousLeachNitrate.getFluid(7000))
                .outputs(OreDictUnifier.get(dust, SilverChloride, 4))
                .fluidOutputs(CopperLeach.getFluid(3000))
                .fluidOutputs(DiluteNitricAcid.getFluid(4000))
                .buildAndRegister();

        CHEMICAL_RECIPES.recipeBuilder().duration(800)
                .input(dust, SilverChloride, 2)
                .input(dust, SodiumHydroxide)
                .fluidInputs(Water.getFluid(1000))
                .outputs(OreDictUnifier.get(dust, SilverOxide, 2))
                .fluidOutputs(Chlorine.getFluid(1000))
                .buildAndRegister();

        BLAST_RECIPES.recipeBuilder().duration(80).EUt(120).blastFurnaceTemp(1200)
                .input(dust, SilverOxide, 2)
                .input(dust, Carbon)
                .outputs(OreDictUnifier.get(ingot, Silver, 3))
                .outputs(OreDictUnifier.get(dustTiny, Ash, 2))
                .fluidOutputs(CarbonDioxide.getFluid(1000))
                .buildAndRegister();

        CHEMICAL_DEHYDRATOR_RECIPES.recipeBuilder().EUt(30).duration(3000)
                .fluidInputs(CopperLeach.getFluid(100))
                .chancedOutput(OreDictUnifier.get(dust, CopperLeach), 9000, 1000)
                .chancedOutput(OreDictUnifier.get(dust, CopperLeach), 9000, 1000)
                .chancedOutput(OreDictUnifier.get(dust, CopperLeach), 9000, 1000)
                .chancedOutput(OreDictUnifier.get(dust, CopperLeach), 9000, 500)
                .chancedOutput(OreDictUnifier.get(dust, CopperLeach), 9000, 500)
                .chancedOutput(OreDictUnifier.get(dust, CopperLeach), 9000, 350)
                .chancedOutput(OreDictUnifier.get(dust, CopperLeach), 9000, 350)
                .chancedOutput(OreDictUnifier.get(dust, CopperLeach), 9000, 350)
                .chancedOutput(OreDictUnifier.get(dust, CopperLeach), 9000, 250)
                .fluidOutputs(NitricAcid.getFluid(6000))
                .buildAndRegister();

        THERMAL_CENTRIFUGE_RECIPES.recipeBuilder().duration(100).EUt(120)
                .input(dust, CopperLeach, 9)
                .outputs(OreDictUnifier.get(dust, Copper, 3))
                .chancedOutput(OreDictUnifier.get(dust, Iron), 5000, 0)
                .chancedOutput(OreDictUnifier.get(dust, Nickel), 5000, 0)
                .buildAndRegister();


    }
}
