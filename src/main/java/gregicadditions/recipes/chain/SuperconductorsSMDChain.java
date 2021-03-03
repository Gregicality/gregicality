package gregicadditions.recipes.chain;

import gregicadditions.GAEnums;
import gregicadditions.item.GAMetaBlocks;
import gregicadditions.item.GASimpleBlock;
import gregicadditions.materials.SimpleDustMaterial;
import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.stack.UnificationEntry;
import net.minecraft.item.ItemStack;

import static gregicadditions.GAMaterials.*;
import static gregicadditions.item.GAMetaItems.*;
import static gregicadditions.recipes.GARecipeMaps.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;

public class SuperconductorsSMDChain {
    public static void init() {
        MIXER_RECIPES.recipeBuilder().duration(240).EUt(320)
                .input(dust, Copper)
                .input(dust, Indium)
                .input(dust, Gallium)
                .outputs(CopperGalliumIndiumMix.getItemStack(3))
                .buildAndRegister();

        // 2H + Se = H2Se
        CHEMICAL_RECIPES.recipeBuilder().duration(280).EUt(670)
                .fluidInputs(Hydrogen.getFluid(2000))
                .input(dust, Selenium)
                .fluidOutputs(HydroselenicAcid.getFluid(1000))
                .buildAndRegister();

        // 2H2Se + 2O + CuInGa = CuInGaSe2 + 2H2O
        CHEMICAL_RECIPES.recipeBuilder().duration(280).EUt(820)
                .fluidInputs(HydroselenicAcid.getFluid(2000))
                .fluidInputs(Oxygen.getFluid(2000))
                .inputs(CopperGalliumIndiumMix.getItemStack(3))
                .outputs(CopperGalliumIndiumSelenide.getItemStack())
                .fluidOutputs(Water.getFluid(2000))
                .buildAndRegister();

        // MnO2 + 2KOH + O = K2MnO4 + H2O
        CHEMICAL_RECIPES.recipeBuilder().duration(270).EUt(740)
                .input(dust, Pyrolusite, 3)
                .fluidInputs(PotassiumHydroxide.getFluid(2000))
                .fluidInputs(Oxygen.getFluid(1000))
                .outputs(PotassiumManganate.getItemStack(7))
                .fluidOutputs(Water.getFluid(1000))
                .buildAndRegister();

        // La2O3 + 2CaO + K2MnO4 = 2LaCaMnO3 + K2O + 4O
        BLAST_RECIPES.recipeBuilder().duration(380).EUt(1200).blastFurnaceTemp(900)
                .inputs(LanthanumOxide.getItemStack(5))
                .input(dust, Quicklime, 4)
                .inputs(PotassiumManganate.getItemStack(7))
                .outputs(LanthanumCalciumManganate.getItemStack(12))
                .outputs(OreDictUnifier.get(dust, Potash, 3))
                .fluidOutputs(Oxygen.getFluid(4000))
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder().duration(230).EUt(250)
                .input(dust, Iron)
                .input(dust, Platinum)
                .outputs(IronPlatinumCatalyst.getItemStack(2))
                .buildAndRegister();

        // C6H6O + HNO3 + H = H2O + C6H7NO
        CHEMICAL_RECIPES.recipeBuilder().duration(340).EUt(1300)
                .fluidInputs(Phenol.getFluid(1000))
                .fluidInputs(NitricAcid.getFluid(1000))
                .fluidInputs(Hydrogen.getFluid(1000))
                .notConsumable(IronPlatinumCatalyst.getItemStack())
                .fluidOutputs(Water.getFluid(1000))
                .fluidOutputs(Aminophenol.getFluid(1000))
                .buildAndRegister();

        // C6H7NO + C3H8O3 + O = C9H7NO + 4H2O
        LARGE_CHEMICAL_RECIPES.recipeBuilder().duration(260).EUt(780)
                .fluidInputs(Aminophenol.getFluid(1000))
                .fluidInputs(Glycerol.getFluid(1000))
                .fluidInputs(Oxygen.getFluid(1000))
                .fluidInputs(NitroBenzene.getFluid(10))
                .fluidOutputs(Hydroquinoline.getFluid(1000))
                .fluidOutputs(Water.getFluid(400))
                .fluidOutputs(NitroBenzene.getFluid(10))
                .buildAndRegister();

        CHEMICAL_BATH_RECIPES.recipeBuilder().duration(350).EUt(1400)
                .fluidInputs(Hydroquinoline.getFluid(1000))
                .input(dust, Aluminium)
                .outputs(AluminiumComplex.getItemStack())
                .buildAndRegister();

        // Na2O4Ru + 2H + RuO2 + 2NaOH
        BLAST_RECIPES.recipeBuilder().duration(270).EUt(1500).blastFurnaceTemp(1250)
                .input(dust, SodiumRuthenate, 7)
                .fluidInputs(Hydrogen.getFluid(2000))
                .outputs(OreDictUnifier.get(dust, RutheniumDioxide, 3))
                .outputs(OreDictUnifier.get(dust, SodiumHydroxide, 6))
                .buildAndRegister();

        // Bi + HNO3 = [Bi(NO3)3 + H2O] + 3NO2 + 2H2O
        LARGE_CHEMICAL_RECIPES.recipeBuilder().duration(350).EUt(3200)
                .input(dust, Bismuth)
                .fluidInputs(NitricAcid.getFluid(6000))
                .fluidOutputs(BismuthNitrateSoluton.getFluid(1000))
                .fluidOutputs(NitrogenDioxide.getFluid(3000))
                .fluidOutputs(Water.getFluid(2000))
                .buildAndRegister();

        // 2Na2O4Ru + 2[Bi(NO3)3 + H2O] = Bi2Ru2O7 + 4NaNO3 + N2H4 + 9O
        LARGE_CHEMICAL_RECIPES.recipeBuilder().duration(320).EUt(1500)
                .input(dust, SodiumRuthenate, 14)
                .fluidInputs(BismuthNitrateSoluton.getFluid(2000))
                .fluidOutputs(Hydrazine.getFluid(1000))
                .fluidOutputs(Oxygen.getFluid(9000))
                .outputs(OreDictUnifier.get(dust, BismuthRuthenate))
                .outputs(OreDictUnifier.get(dust, SodiumNitrate, 20))
                .buildAndRegister();

        // NaNO3 -> Na + N + 3O
        ELECTROLYZER_RECIPES.recipeBuilder().duration(270).EUt(120)
                .input(dust, SodiumNitrate, 5)
                .outputs(OreDictUnifier.get(dust, Sodium))
                .fluidOutputs(Nitrogen.getFluid(1000))
                .fluidOutputs(Oxygen.getFluid(3000))
                .buildAndRegister();

        // 2IrO2 + 2[Bi(NO3)3 + H2O] + H = Bi2Ir2O7 + 4NO2
        CHEMICAL_RECIPES.recipeBuilder().duration(300).EUt(3500)
                .input(dust, IridiumDioxide,6)
                .fluidInputs(BismuthNitrateSoluton.getFluid(2000))
                .fluidInputs(Hydrogen.getFluid(1000))
                .outputs(OreDictUnifier.get(dust, BismuthIridiate))
                .fluidOutputs(NitricAcid.getFluid(4000))
                .buildAndRegister();

        // BaCl3 + H2O = [BaCl3 + H2O]
        MIXER_RECIPES.recipeBuilder().duration(230).EUt(250)
                .inputs(BariumChloride.getItemStack(3))
                .fluidInputs(DistilledWater.getFluid(1000))
                .fluidOutputs(BariumChlorideSolution.getFluid(1000))
                .buildAndRegister();

        // TiCl4¬ + [NaOH + H2O] + [BaCl2 + H2O] = BaTiO3 + NaCl + 4HCl + H
        CHEMICAL_PLANT_RECIPES.recipeBuilder().duration(320).EUt(4500)
                .fluidInputs(TitaniumTetrachloride.getFluid(1000))
                .fluidInputs(SodiumHydroxideSolution.getFluid(1000))
                .fluidInputs(BariumChlorideSolution.getFluid(1000))
                .outputs(OreDictUnifier.get(dust, Salt, 2))
                .fluidOutputs(BariumTitanatePreparation.getFluid(1000))
                .fluidOutputs(HydrochloricAcid.getFluid(4000))
                .fluidOutputs(Hydrogen.getFluid(1000))
                .buildAndRegister();

        // Maintain 2:1 Ratio
        CHEMICAL_DEHYDRATOR_RECIPES.recipeBuilder().duration(290).EUt(2300)
                .fluidInputs(BariumTitanatePreparation.getFluid(500))
                .outputs(OreDictUnifier.get(dust, BariumTitanate))
                .buildAndRegister();

        // H2S + C4H6O4 + 4Br = C4Br4S + 4H2O
        CHEMICAL_PLANT_RECIPES.recipeBuilder().duration(230).EUt(4960)
                .inputs(SuccinicAcid.getItemStack())
                .fluidInputs(HydrogenSulfide.getFluid(1000))
                .fluidInputs(Bromine.getFluid(4000))
                .fluidOutputs(Perbromothiophene.getFluid(1000))
                .fluidOutputs(Water.getFluid(1000))
                .buildAndRegister();

        // C4Br4S + C2H4O2 + CH4O + CO = C6H8S + 4Br + 2CO2
        LARGE_CHEMICAL_RECIPES.recipeBuilder().duration(180).EUt(3200)
                .notConsumable(dust, Zinc)
                .notConsumable(dust, SodiumHydroxide)
                .notConsumable(new IntCircuitIngredient(10))
                .fluidInputs(Perbromothiophene.getFluid(1000))
                .fluidInputs(AceticAcid.getFluid(1000))
                .fluidInputs(Methanol.getFluid(1000))
                .fluidInputs(CarbonMonoxde.getFluid(1000))
                .fluidOutputs(Dimetoxythiophene.getFluid(1000))
                .fluidOutputs(Bromine.getFluid(4000))
                .fluidOutputs(CarbonDioxide.getFluid(2000))
                .buildAndRegister();

        // C2H6O2 + C6H8S = C6H6O2S + 2CH4
        CHEMICAL_RECIPES.recipeBuilder().duration(240).EUt(2000)
                .notConsumable(GELLED_TOLUENE)
                .fluidInputs(EthyleneGlycol.getFluid(1000))
                .fluidInputs(Dimetoxythiophene.getFluid(1000))
                .fluidOutputs(EDOT.getFluid(1000))
                .fluidOutputs(Methane.getFluid(2000))
                .buildAndRegister();

        // (C8H8)n + H2SO4 + C6H6O2S (aka: EDOT) = PEDOT + Dilute H2SO4
        CHEMICAL_PLANT_RECIPES.recipeBuilder().duration(320).EUt(3200)
                .fluidInputs(Polystyrene.getFluid(1000))
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .fluidInputs(EDOT.getFluid(1000))
                .fluidInputs(SodiumPersulfate.getFluid(10))
                .notConsumable(IronSulfateDust.getItemStack())
                .fluidOutputs(DilutedSulfuricAcid.getFluid(1000))
                .fluidOutputs(SodiumPersulfate.getFluid(10))
                .outputs(OreDictUnifier.get(dust, PEDOT, 3))
                .buildAndRegister();

        // Fe + H2SO4 = FeSO4 + 2H
        CHEMICAL_RECIPES.recipeBuilder().duration(250).EUt(500)
                .input(dust, Iron)
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .outputs(IronSulfateDust.getItemStack())
                .fluidOutputs(Hydrogen.getFluid(2000))
                .buildAndRegister();

        // ZrCl4 + 2H2O = ZrOCl2 + 2HCl
        CHEMICAL_RECIPES.recipeBuilder().duration(250).EUt(1000)
                .inputs(ZirconiumTetrachloride.getItemStack(5))
                .fluidInputs(Water.getFluid(2000))
                .outputs(ZirconylChloride.getItemStack(4))
                .fluidOutputs(HydrochloricAcid.getFluid(2000))
                .buildAndRegister();

        // Pb + N2O4 + 2O = Pb(NO3)2
        CHEMICAL_RECIPES.recipeBuilder().EUt(8000).duration(250)
                .input(dust, Lead)
                .fluidInputs(NitrogenTetroxide.getFluid(1000))
                .fluidInputs(Oxygen.getFluid(2000))
                .outputs(OreDictUnifier.get(dust, LeadNitrate, 4))
                .buildAndRegister();

        // ZrOCl2 + TiO2 + Pb(NO3)2 + 2H = PbZrTiO3 + 2HNO3 + 2Cl
        LARGE_CHEMICAL_RECIPES.recipeBuilder().duration(320).EUt(1700)
                .inputs(ZirconylChloride.getItemStack(4))
                .input(dust, Rutile, 3)
                .input(dust, LeadNitrate)
                .fluidInputs(Hydrogen.getFluid(2000))
                .fluidOutputs(NitricAcid.getFluid(2000))
                .fluidOutputs(Chlorine.getFluid(2000))
                .outputs(OreDictUnifier.get(dust, LeadZirconateTitanate, 6))
                .buildAndRegister();

        AUTOCLAVE_RECIPES.recipeBuilder().duration(560).EUt(2000)
                .input(dust, LeadZirconateTitanate, 4)
                .fluidInputs(DistilledWater.getFluid(2000))
                .outputs(OreDictUnifier.get(gemExquisite, LeadZirconateTitanate))
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder().duration(430).EUt(30720)
                .input(gemExquisite, LeadZirconateTitanate, 2)
                .input(wireFine, Gold)
                .fluidInputs(SolderingAlloy.getFluid(288))
                .outputs(PIEZOELECTRIC_CRYSTAL.getStackForm())
                .buildAndRegister();

        BLAST_RECIPES.recipeBuilder().duration(500).EUt(1900).blastFurnaceTemp(2400)
                .input(dust, Tungsten, 9)
                .input(GAEnums.GAOrePrefix.oxide, Thorium)
                .outputs(OreDictUnifier.get(ingot, ThoriumDopedTungsten, 10))
                .buildAndRegister();

        BLAST_RECIPES.recipeBuilder().duration(270).EUt(800).blastFurnaceTemp(1800)
                .input(dust, Quartzite)
                .inputs(Alumina.getItemStack())
                .notConsumable(SHAPE_MOLD_CYLINDER)
                .outputs(ALUMINO_SILICATE_GLASS_TUBE.getStackForm())
                .buildAndRegister();

        BLAST_ALLOY_RECIPES.recipeBuilder().duration(290).EUt(1700)
                .input(dust, SiliconDioxide)
                .inputs(BariumOxide.getItemStack())
                .input(dust, Garnierite)
                .input(dust, SodaAsh)
                .fluidOutputs(WoodsGlass.getFluid(576))
                .buildAndRegister();

        // Fe + 2I = FeI2
        CHEMICAL_RECIPES.recipeBuilder().duration(150).EUt(780)
                .input(dust, Iron)
                .input(dust, Iodine, 2)
                .outputs(IronIodide.getItemStack())
                .buildAndRegister();
        // Tl + I = TlI
        CHEMICAL_RECIPES.recipeBuilder().duration(150).EUt(780)
                .input(dust, Thallium)
                .input(dust, Iodine)
                .outputs(ThalliumIodide.getItemStack())
                .buildAndRegister();
        // Rb + I = RbI
        CHEMICAL_RECIPES.recipeBuilder().duration(150).EUt(780)
                .input(dust, Rubidium)
                .input(dust, Iodine)
                .outputs(RubidiumIodide.getItemStack())
                .buildAndRegister();
        // K + I = KI
        CHEMICAL_RECIPES.recipeBuilder().duration(150).EUt(780)
                .input(dust, Potassium)
                .input(dust, Iodine)
                .outputs(PotassiumIodide.getItemStack())
                .buildAndRegister();
        // In + 3I = InI3
        CHEMICAL_RECIPES.recipeBuilder().duration(150).EUt(780)
                .input(dust, Indium)
                .input(dust, Iodine, 3)
                .outputs(IndiumIodide.getItemStack())
                .buildAndRegister();
        // Ga + 3I = GaI3
        CHEMICAL_RECIPES.recipeBuilder().duration(150).EUt(780)
                .input(dust, Gallium)
                .input(dust, Iodine, 3)
                .outputs(GalliumIodide.getItemStack())
                .buildAndRegister();
        // Sc + 3I = ScI3
        CHEMICAL_RECIPES.recipeBuilder().duration(150).EUt(780)
                .input(dust, Scandium)
                .input(dust, Iodine, 3)
                .outputs(ScandiumIodide.getItemStack())
                .buildAndRegister();

        // FeI2 + 5CO = 2I + Fe(CO)5 (all x5)
        LARGE_CHEMICAL_RECIPES.recipeBuilder().duration(240).EUt(680)
                .inputs(IronIodide.getItemStack(5))
                .fluidInputs(CarbonMonoxde.getFluid(25000))
                .notConsumable(block, Copper)
                .outputs(OreDictUnifier.get(dust, Iodine, 10))
                .outputs(OreDictUnifier.get(dust, Iron))
                .fluidOutputs(IronCarbonyl.getFluid(5000))
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder().duration(300).EUt(780)
                .fluidInputs(IronCarbonyl.getFluid(1000))
                .fluidOutputs(PurifiedIronCarbonyl.getFluid(900))
                .buildAndRegister();

        ELECTROLYZER_RECIPES.recipeBuilder().duration(340).EUt(900)
                .fluidInputs(PurifiedIronCarbonyl.getFluid(1000))
                .outputs(CarbonylPurifiedIron.getItemStack())
                .fluidOutputs(CarbonMonoxde.getFluid(5000))
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder().duration(290).EUt(2000)
                .inputs(SMALL_COIL.getStackForm(4))
                .inputs(CarbonylPurifiedIron.getItemStack())
                .input(wireFine, AnnealedCopper, 2)
                .fluidInputs(SolderingAlloy.getFluid(144))
                .outputs(INDUCTOR.getStackForm())
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder().duration(290).EUt(1500)
                .inputs(RESISTOR.getStackForm())
                .inputs(INDUCTOR.getStackForm())
                .input(wireFine, Cupronickel, 2)
                .outputs(BALLAST.getStackForm())
                .buildAndRegister();

        // 2V + 5Na2CO3 + 4H2O = 5CO + 2NaVO3 + 8NaOH
        BLAST_RECIPES.recipeBuilder().duration(100).EUt(1920).blastFurnaceTemp(650)
                .input(dust, Vanadium, 2)
                .input(dust, SodaAsh, 30)
                .fluidInputs(Water.getFluid(4000))
                .fluidOutputs(CarbonMonoxde.getFluid(5000))
                .outputs(SodiumMetavanadate.getItemStack(10))
                .outputs(OreDictUnifier.get(dust, SodiumHydroxide, 24))
                .buildAndRegister();

        // Y2O3 + Eu2O3 + V2O5 + 6H = 2YEuVO4 + 3H2O
        BLAST_RECIPES.recipeBuilder().duration(340).EUt(3400).blastFurnaceTemp(1200)
                .input(dust, YttriumOxide)
                .inputs(EuropiumOxide.getItemStack(5))
                .inputs(VanadiumOxide.getItemStack(5))
                .fluidInputs(Hydrogen.getFluid(6000))
                .outputs(YttriumEuropiumVanadate.getItemStack(2))
                .fluidOutputs(Steam.getFluid(3000))
                .buildAndRegister();

        // SrCl2 + H2SO4 = SrSO4 + 2HCl
        CHEMICAL_RECIPES.recipeBuilder().duration(200).EUt(480)
                .inputs(StrontiumChloride.getItemStack())
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .outputs(StrontiumSulfate.getItemStack())
                .fluidOutputs(HydrochloricAcid.getFluid(2000))
                .buildAndRegister();

        // 2SrO + Eu2O3 + 2Al2O3 + 6H = 2SrEuAl2O4 + 3H2O
        BLAST_RECIPES.recipeBuilder().duration(340).EUt(3400).blastFurnaceTemp(1200)
                .inputs(StrontiumOxide.getItemStack(4))
                .inputs(EuropiumOxide.getItemStack(5))
                .inputs(Alumina.getItemStack(2))
                .fluidInputs(Hydrogen.getFluid(6000))
                .outputs(StrontiumEuropiumAluminate.getItemStack(2))
                .fluidOutputs(Steam.getFluid(3000))
                .buildAndRegister();

        ItemStack[] halides = {ThalliumIodide.getItemStack(), RubidiumIodide.getItemStack(), IndiumIodide.getItemStack(), ScandiumIodide.getItemStack(), GalliumIodide.getItemStack()};
        SimpleDustMaterial[] mixtures = {GreenHalideMix, RedHalideMix, BlueHalideMix, WhiteHalideMix, UVAHalideMix};
        ItemStack[] lamp_cores = {GREEN_LAMP_CORE.getStackForm(), RED_LAMP_CORE.getStackForm(), BLUE_LAMP_CORE.getStackForm(), WHITE_LAMP_CORE.getStackForm(), UVA_LAMP_CORE.getStackForm()};
        MetaItem.MetaValueItem[] halide_lamp = {GREEN_HALIDE_LAMP, RED_HALIDE_LAMP, BLUE_HALIDE_LAMP, WHITE_HALIDE_LAMP, UVA_HALIDE_LAMP};

        for (int i = 0; i < 5; i++) {
            MIXER_RECIPES.recipeBuilder().duration(320).EUt(720)
                    .inputs(halides[i])
                    .inputs(PotassiumIodide.getItemStack())
                    .fluidInputs(Mercury.getFluid(1000))
                    .outputs(mixtures[i].getItemStack(2))
                    .buildAndRegister();

            ASSEMBLY_LINE_RECIPES.recipeBuilder().duration(240).EUt(2000)
                    .inputs(mixtures[i].getItemStack())
                    .input(foil, Molybdenum, 2)
                    .input(wireFine, ThoriumDopedTungsten, 4)
                    .inputs(ALUMINO_SILICATE_GLASS_TUBE.getStackForm())
                    .input(plate, CubicZirconia, 2)
                    .fluidInputs(Argon.getFluid(1000))
                    .fluidInputs(SolderingAlloy.getFluid(288))
                    .outputs(lamp_cores[i])
                    .buildAndRegister();

            if (i == 4) {
                ASSEMBLER_RECIPES.recipeBuilder().duration(290).EUt(2000)
                        .inputs(lamp_cores[i])
                        .input(stick, MaragingSteel250, 4)
                        .inputs(BALLAST.getStackForm())
                        .input(foil, Electrum, 2)
                        .input(plate, WoodsGlass, 2)
                        .inputs(YttriumEuropiumVanadate.getItemStack())
                        .fluidInputs(Nitrogen.getFluid(1000))
                        .outputs(halide_lamp[i].getStackForm())
                        .buildAndRegister();

                ASSEMBLER_RECIPES.recipeBuilder().duration(290).EUt(2000)
                        .inputs(lamp_cores[i])
                        .input(stick, MaragingSteel250, 4)
                        .inputs(BALLAST.getStackForm())
                        .input(foil, Electrum, 2)
                        .input(plate, WoodsGlass, 2)
                        .inputs(StrontiumEuropiumAluminate.getItemStack())
                        .fluidInputs(Nitrogen.getFluid(1000))
                        .outputs(halide_lamp[i].getStackForm())
                        .buildAndRegister();

                ASSEMBLY_LINE_RECIPES.recipeBuilder().duration(410).EUt(6000)
                        .inputs(mixtures[i].getItemStack())
                        .input(foil, Molybdenum, 2)
                        .input(wireFine, ThoriumDopedTungsten, 4)
                        .inputs(ALUMINO_SILICATE_GLASS_TUBE.getStackForm())
                        .input(plate, CubicZirconia, 2)
                        .fluidInputs(Xenon.getFluid(500))
                        .fluidInputs(SolderingAlloy.getFluid(432))
                        .input(stick, MaragingSteel250, 4)
                        .inputs(BALLAST.getStackForm())
                        .input(foil, Electrum, 2)
                        .input(plate, WoodsGlass, 2)
                        .inputs(YttriumEuropiumVanadate.getItemStack())
                        .fluidInputs(Nitrogen.getFluid(1000))
                        .outputs(halide_lamp[i].getStackForm(2))
                        .buildAndRegister();

                ASSEMBLY_LINE_RECIPES.recipeBuilder().duration(410).EUt(6000)
                        .inputs(mixtures[i].getItemStack())
                        .input(foil, Molybdenum, 2)
                        .input(wireFine, ThoriumDopedTungsten, 4)
                        .inputs(ALUMINO_SILICATE_GLASS_TUBE.getStackForm())
                        .input(plate, CubicZirconia, 2)
                        .fluidInputs(Xenon.getFluid(500))
                        .fluidInputs(SolderingAlloy.getFluid(432))
                        .input(stick, MaragingSteel250, 4)
                        .inputs(BALLAST.getStackForm())
                        .input(foil, Electrum, 2)
                        .input(plate, WoodsGlass, 2)
                        .inputs(StrontiumEuropiumAluminate.getItemStack())
                        .fluidInputs(Nitrogen.getFluid(1000))
                        .outputs(halide_lamp[i].getStackForm(2))
                        .buildAndRegister();

            } else {
                ASSEMBLER_RECIPES.recipeBuilder().duration(290).EUt(2000)
                        .inputs(lamp_cores[i])
                        .input(stick, MaragingSteel250, 4)
                        .inputs(BALLAST.getStackForm())
                        .input(foil, Electrum, 2)
                        .input(plate, BorosilicateGlass, 2)
                        .inputs(YttriumEuropiumVanadate.getItemStack())
                        .fluidInputs(Nitrogen.getFluid(1000))
                        .outputs(halide_lamp[i].getStackForm())
                        .buildAndRegister();

                ASSEMBLER_RECIPES.recipeBuilder().duration(290).EUt(2000)
                        .inputs(lamp_cores[i])
                        .input(stick, MaragingSteel250, 4)
                        .inputs(BALLAST.getStackForm())
                        .input(foil, Electrum, 2)
                        .input(plate, BorosilicateGlass, 2)
                        .inputs(StrontiumEuropiumAluminate.getItemStack())
                        .fluidInputs(Nitrogen.getFluid(1000))
                        .outputs(halide_lamp[i].getStackForm())
                        .buildAndRegister();

                ASSEMBLY_LINE_RECIPES.recipeBuilder().duration(410).EUt(6000)
                        .inputs(mixtures[i].getItemStack())
                        .input(foil, Molybdenum, 2)
                        .input(wireFine, ThoriumDopedTungsten, 4)
                        .inputs(ALUMINO_SILICATE_GLASS_TUBE.getStackForm())
                        .input(plate, CubicZirconia, 2)
                        .fluidInputs(Xenon.getFluid(500))
                        .fluidInputs(SolderingAlloy.getFluid(432))
                        .input(stick, MaragingSteel250, 4)
                        .inputs(BALLAST.getStackForm())
                        .input(foil, Electrum, 2)
                        .input(plate, BorosilicateGlass, 2)
                        .inputs(YttriumEuropiumVanadate.getItemStack())
                        .fluidInputs(Nitrogen.getFluid(1000))
                        .outputs(halide_lamp[i].getStackForm(2))
                        .buildAndRegister();

                ASSEMBLY_LINE_RECIPES.recipeBuilder().duration(410).EUt(6000)
                        .inputs(mixtures[i].getItemStack())
                        .input(foil, Molybdenum, 2)
                        .input(wireFine, ThoriumDopedTungsten, 4)
                        .inputs(ALUMINO_SILICATE_GLASS_TUBE.getStackForm())
                        .input(plate, CubicZirconia, 2)
                        .fluidInputs(Xenon.getFluid(500))
                        .fluidInputs(SolderingAlloy.getFluid(432))
                        .input(stick, MaragingSteel250, 4)
                        .inputs(BALLAST.getStackForm())
                        .input(foil, Electrum, 2)
                        .input(plate, BorosilicateGlass, 2)
                        .inputs(StrontiumEuropiumAluminate.getItemStack())
                        .fluidInputs(Nitrogen.getFluid(1000))
                        .outputs(halide_lamp[i].getStackForm(2))
                        .buildAndRegister();

            }
        }

        // 6F + 2CS2 = C2F6S2 + 2S
        CHEMICAL_RECIPES.recipeBuilder().duration(250).EUt(740)
                .notConsumable(dust, Iodine)
                .fluidInputs(Fluorine.getFluid(6000))
                .fluidInputs(CarbonSulfide.getFluid(2000))
                .fluidOutputs(Biperfluoromethanedisulfide.getFluid(1000))
                .outputs(OreDictUnifier.get(dust, Sulfur, 2))
                .buildAndRegister();

        // Hg + 3H2O2 + C2F6S2 + BaCO3 = [C2BaF6O6S2 + 3H2O + Hg] (carbon is voided)
        CHEMICAL_RECIPES.recipeBuilder().duration(240).EUt(960)
                .fluidInputs(Mercury.getFluid(1000))
                .fluidInputs(Water.getFluid(3000))
                .fluidInputs(Biperfluoromethanedisulfide.getFluid(1000))
                .inputs(BariumCarbonate.getItemStack())
                .notConsumable(UVA_HALIDE_LAMP.getStackForm())
                .fluidOutputs(BariumTriflateSolution.getFluid(3000))
                .buildAndRegister();

        // Voids a carbon as a result of above
        DISTILLATION_RECIPES.recipeBuilder().duration(320).EUt(1200)
                .fluidInputs(BariumTriflateSolution.getFluid(3000))
                .outputs(BariumTriflate.getItemStack())
                .fluidOutputs(Mercury.getFluid(1000))
                .fluidOutputs(Water.getFluid(3000))
                .buildAndRegister();

        // 3H2SO4 + 2Sc + 3C2BaF6O6S2 = 3BaSO4 + 2C3F9O9S3Sc + 6H
        LARGE_CHEMICAL_RECIPES.recipeBuilder().duration(200).EUt(1100)
                .fluidInputs(SulfuricAcid.getFluid(3000))
                .input(dust, Scandium, 2)
                .inputs(BariumTriflate.getItemStack(3))
                .outputs(OreDictUnifier.get(dust, Barite, 3))
                .outputs(ScandiumTriflate.getItemStack(2))
                .fluidOutputs(Hydrogen.getFluid(6000))
                .buildAndRegister();

        // 2HNO3 + BaS = H2S + Ba(NO3)2
        CHEMICAL_RECIPES.recipeBuilder().duration(240).EUt(8000)
                .fluidInputs(NitricAcid.getFluid(2000))
                .inputs(BariumSulfide.getItemStack(2))
                .fluidOutputs(HydrogenSulfide.getFluid(1000))
                .outputs(BariumNitrate.getItemStack(9))
                .buildAndRegister();

        // 2HNO3 + Cu = 2H + Cu(NO3)2
        CHEMICAL_RECIPES.recipeBuilder().duration(240).EUt(8000)
                .fluidInputs(NitricAcid.getFluid(2000))
                .input(dust, Copper)
                .fluidOutputs(NitrogenDioxide.getFluid(1000))
                .fluidOutputs(Hydrogen.getFluid(2000))
                .outputs(CopperNitrate.getItemStack(9))
                .buildAndRegister();

        // 6HNO3 + Y2O3 = 3H2O + 2Y(NO3)3
        CHEMICAL_RECIPES.recipeBuilder().duration(240).EUt(8000)
                .fluidInputs(NitricAcid.getFluid(6000))
                .input(dust, YttriumOxide, 5)
                .fluidOutputs(Water.getFluid(3000))
                .outputs(YttriumNitrate.getItemStack(26))
                .buildAndRegister();

        // 6C3H8O3 + 5HCl + 3HClO + 8N = 3C6H8O7 + 8NH4Cl
        LARGE_CHEMICAL_RECIPES.recipeBuilder().duration(280).EUt(6200)
                .fluidInputs(Glycerol.getFluid(6000))
                .fluidInputs(HydrochloricAcid.getFluid(5000))
                .fluidInputs(HypochlorousAcid.getFluid(3000))
                .fluidInputs(Nitrogen.getFluid(8000))
                .notConsumable(dust, Potassiumdichromate)
                .notConsumable(new IntCircuitIngredient(0))
                .fluidOutputs(CitricAcid.getFluid(3000))
                .fluidOutputs(AmmoniumChloride.getFluid(8000))
                .buildAndRegister();

        CHEMICAL_PLANT_RECIPES.recipeBuilder().duration(300).EUt(6400)
                .inputs(CopperNitrate.getItemStack(27))
                .inputs(BariumNitrate.getItemStack(18))
                .inputs(YttriumNitrate.getItemStack(13))
                .fluidInputs(Ammonia.getFluid(2000))
                .fluidInputs(CitricAcid.getFluid(4000))
                .outputs(WellMixedYBCOxides.getItemStack(12))
                .fluidOutputs(GasMixture.getFluid(6000))
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder().duration(340).EUt(3200)
                .fluidInputs(GasMixture.getFluid(16000))
                .fluidOutputs(CarbonDioxide.getFluid(5500))
                .fluidOutputs(Oxygen.getFluid(2500))
                .fluidOutputs(Nitrogen.getFluid(3500))
                .fluidOutputs(NitrogenDioxide.getFluid(4500))
                .buildAndRegister();

        // YBa2Cu3O6 + O -> YBa2Cu3O7
        BLAST_RECIPES.recipeBuilder().duration(5000).EUt(8000).blastFurnaceTemp(4500)
                .inputs(WellMixedYBCOxides.getItemStack(12))
                .fluidInputs(Oxygen.getFluid(1000))
                .outputs(OreDictUnifier.get(ingotHot, YttriumBariumCuprate, 13))
                .buildAndRegister();

        // 2Th + 2Ba + 3Cu + 2Ca = TBCC
        ASSEMBLER_RECIPES.recipeBuilder().duration(360).EUt(128000)
                .input(foil, Thallium, 2)
                .input(foil, Barium, 2)
                .input(foil, Copper, 3)
                .input(foil, Calcium, 2)
                .outputs(PiledTBCC.getItemStack(9))
                .buildAndRegister();

        // [2Th + 2Ba + 3Cu + 2Ca] + 10O = TBCCO
        BLAST_RECIPES.recipeBuilder().duration(240).EUt(104000).blastFurnaceTemp(1800)
                .inputs(PiledTBCC.getItemStack())
                .fluidInputs(Oxygen.getFluid(10000))
                .outputs(TBCCODust.getItemStack())
                .buildAndRegister();

        // 9O + C6H12O6 = 3C2H2O4 + 3H2O
        CHEMICAL_RECIPES.recipeBuilder().duration(320).EUt(20000)
                .notConsumable(VanadiumOxide.getItemStack())
                .fluidInputs(Oxygen.getFluid(9000))
                .inputs(Glucose.getItemStack())
                .fluidOutputs(Water.getFluid(3000))
                .fluidOutputs(OxalicAcid.getFluid(3000))
                .buildAndRegister();

        // 3C2H2O4 + 2Ac = C6H6Ac2O12
        CHEMICAL_RECIPES.recipeBuilder().duration(280).EUt(5600000)
                .fluidInputs(OxalicAcid.getFluid(3000))
                .input(dust, Actinium, 2)
                .outputs(ActiniumOxalate.getItemStack(26))
                .buildAndRegister();

        // C + 4Cl = CCl4
        CHEMICAL_RECIPES.recipeBuilder().duration(320).EUt(2000)
                .input(dust, Carbon)
                .notConsumable(new IntCircuitIngredient(0))
                .fluidInputs(Chlorine.getFluid(4000))
                .fluidOutputs(CarbonTetrachloride.getFluid(1000))
                .buildAndRegister();

        // TODO Which Actinium Hydride Should it be
        BLAST_RECIPES.recipeBuilder().duration(230).EUt(6000000)
                .blastFurnaceTemp(10000)
                .inputs(ActiniumOxalate.getItemStack())
                .inputs(SodiumHydride.getItemStack(2))
                .input(dust, Sodium, 2)
                .fluidInputs(CarbonTetrachloride.getFluid(1000))
                .outputs(ActiniumHydride.getItemStack())
                .outputs(OreDictUnifier.get(dust, Salt, 4))
                .fluidOutputs(CarbonDioxide.getFluid(1000))
                .buildAndRegister();

        // TODO See above
        STELLAR_FORGE_RECIPES.recipeBuilder().duration(260).EUt(7800000)
                .inputs(GAMetaBlocks.SIMPLE_BLOCK.getItemVariant(GASimpleBlock.CasingType.NAQUADRIA_CHARGE))
                .inputs(ActiniumHydride.getItemStack(18))
                .fluidInputs(Hydrogen.getFluid(162000))
                .fluidOutputs(ActiniumSuperhydridePlasma.getFluid(18000))
                .buildAndRegister();

        FLUID_CANNER_RECIPES.recipeBuilder()
                .inputs(PLASMA_CONTAINMENT_CELL.getStackForm())
                .fluidInputs(ActiniumSuperhydridePlasma.getFluid(1000))
                .outputs(ACTINIUM_PLASMA_CONTAINMENT_CELL.getStackForm())
                .EUt(750000)
                .duration(20)
                .buildAndRegister();

        PLASMA_CONDENSER_RECIPES.recipeBuilder().duration(340).EUt(8380000)
                .inputs(ACTINIUM_PLASMA_CONTAINMENT_CELL.getStackForm())
                .fluidInputs(LiquidHelium.getFluid(24000))
                .outputs(ActiniumSuperhydride.getItemStack())
                .outputs(PLASMA_CONTAINMENT_CELL.getStackForm())
                .fluidOutputs(Helium.getFluid(24000))
                .buildAndRegister();

        // 2La + 2C60 = La2(C60)2
        MIXER_RECIPES.recipeBuilder().duration(240).EUt(4800)
                .input(dust, Lanthanum, 2)
                .inputs(UnfoldedFullerene.getItemStack(2))
                .outputs(LanthanumFullereneMix.getItemStack())
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder().duration(320).EUt(125000)
                .inputs(LanthanumFullereneMix.getItemStack())
                .notConsumable(craftingLens, MarkerMaterials.Color.Magenta)
                .outputs(LanthanumEmbeddedFullerene.getItemStack())
                .buildAndRegister();

        // 3Rb + 3Cs + La2(C60)2 = La2Cs3Rb3C120
        BLAST_RECIPES.recipeBuilder().duration(280).EUt(1400000).blastFurnaceTemp(2400)
                .inputs(LanthanumEmbeddedFullerene.getItemStack())
                .input(dust, Rubidium, 3)
                .input(dust, Caesium, 3)
                .outputs(FullereneSuperconductiveDust.getItemStack(64))
                .outputs(FullereneSuperconductiveDust.getItemStack(64))
                .buildAndRegister();

        // O + Si + 3CHCl3 + 7H2O = C3H9SiCl + 8HClO
        CHEMICAL_RECIPES.recipeBuilder().duration(310).EUt(840)
                .fluidInputs(Oxygen.getFluid(1000))
                .fluidInputs(Chloroform.getFluid(3000))
                .fluidInputs(Water.getFluid(7000))
                .input(dust, Silicon)
                .fluidOutputs(Trimethylchlorosilane.getFluid(1000))
                .fluidOutputs(HypochlorousAcid.getFluid(8000))
                .buildAndRegister();

        // 3CH2O2 + Br + 3Na + C = C3H3BrO + 3NaOH + CO2
        CHEMICAL_RECIPES.recipeBuilder().duration(360).EUt(8000)
                .fluidInputs(FormicAcid.getFluid(3000))
                .fluidInputs(Bromine.getFluid(1000))
                .input(dust, Sodium, 3)
                .input(dust, Carbon)
                .fluidInputs(Trimethylchlorosilane.getFluid(20))
                .outputs(OreDictUnifier.get(dust, SodiumHydroxide, 9))
                .fluidOutputs(Bromoacrolein.getFluid(1000))
                .fluidOutputs(CarbonDioxide.getFluid(1000))
                .buildAndRegister();

        // 3NaOH + 2S + O = NaH + Na2S2O3 + H2O
        BLAST_RECIPES.recipeBuilder().duration(210).EUt(6400).blastFurnaceTemp(4500)
                .input(dust, SodiumHydroxide, 9)
                .input(dust, Sulfur, 2)
                .fluidInputs(Oxygen.getFluid(1000))
                .outputs(SodiumHydride.getItemStack(2))
                .outputs(SodiumThiosulfate.getItemStack(7))
                .fluidOutputs(Steam.getFluid(1000))
                .buildAndRegister();

        // 2Cl + C2H6 = C2H5Cl + HCl
        CHEMICAL_RECIPES.recipeBuilder().duration(200).EUt(3200)
                .fluidInputs(Chlorine.getFluid(2000))
                .fluidInputs(Ethane.getFluid(1000))
                .fluidOutputs(Chloroethane.getFluid(1000))
                .fluidOutputs(HydrochloricAcid.getFluid(1000))
                .notConsumable(UVA_HALIDE_LAMP.getStackForm())
                .buildAndRegister();

        // TODO
        CHEMICAL_RECIPES.recipeBuilder().duration(320).EUt(10000)
                .fluidInputs(Chloroethane.getFluid(1000))
                .inputs(SodiumThiosulfate.getItemStack())
                .fluidInputs(Bromoacrolein.getFluid(1000))
                .outputs(OreDictUnifier.get(dust, Salt))
                .fluidOutputs(Bromohydrothiine.getFluid(2000))
                .buildAndRegister();

        // TODO
        CHEMICAL_RECIPES.recipeBuilder().duration(290).EUt(970000)
                .fluidInputs(Bromohydrothiine.getFluid(1000))
                .fluidInputs(ButhylLithium.getFluid(2000))
                .input(dust, Selenium, 2)
                .fluidOutputs(Bromobutane.getFluid(2000))
                .fluidOutputs(Lithiumthiinediselenide.getFluid(1000))
                .buildAndRegister();

        // TODO
        CHEMICAL_PLANT_RECIPES.recipeBuilder().duration(260).EUt(840000)
                .fluidInputs(TitaniumTetrachloride.getFluid(1000))
                .fluidInputs(Butadiene.getFluid(1000))
                .fluidInputs(Ethylene.getFluid(1000))
                .notConsumable(ScandiumTriflate.getItemStack())
                .fluidOutputs(Chlorine.getFluid(2000))
                .outputs(TitaniumCyclopentanyl.getItemStack(2))
                .buildAndRegister();

        // TODO Where does the titanium go???
        BLAST_RECIPES.recipeBuilder().duration(320).EUt(720000).blastFurnaceTemp(3500)
                .fluidInputs(Lithiumthiinediselenide.getFluid(1000))
                .inputs(TitaniumCyclopentanyl.getItemStack(1))
                .outputs(OreDictUnifier.get(dust, Lithium, 2))
                .outputs(BETS.getItemStack())
                .buildAndRegister();

        // TODO C14H20O4Se4Re???? Titanium????
        BLAST_RECIPES.recipeBuilder().duration(250).EUt(1300000).blastFurnaceTemp(5000)
                .inputs(BETS.getItemStack())
                .fluidInputs(AmmoniumPerrhenate.getFluid(1000))
                .fluidOutputs(Ammonia.getFluid(1000))
                .outputs(BETSPerrhenate.getItemStack())
                .buildAndRegister();

        // C4H9Br + NaOH = NaBr + C4H10O
        CHEMICAL_RECIPES.recipeBuilder().duration(340).EUt(4000)
                .fluidInputs(Bromobutane.getFluid(1000))
                .input(dust, SodiumHydroxide, 3)
                .outputs(SodiumBromide.getItemStack(2))
                .fluidOutputs(Butanol.getFluid(1000))
                .buildAndRegister();

        ELECTROLYZER_RECIPES.recipeBuilder().duration(260).EUt(500)
                .inputs(SodiumBromide.getItemStack(2))
                .outputs(OreDictUnifier.get(dust, Sodium))
                .fluidOutputs(Bromine.getFluid(1000))
                .buildAndRegister();

        // 4Fr + 4C2H2 = Fr4C + C7H8
        CHEMICAL_RECIPES.recipeBuilder().duration(260).EUt(740000)
                .input(dust, Francium, 4)
                .fluidInputs(Acetylene.getFluid(4000))
                .outputs(FranciumCarbide.getItemStack(5))
                .fluidOutputs(Toluene.getFluid(1000))
                .buildAndRegister();

        // 4B + C = B4C
        BLAST_RECIPES.recipeBuilder().duration(350).EUt(84000).blastFurnaceTemp(4000)
                .input(dust, Boron, 4)
                .input(dust, Carbon)
                .outputs(BoronCarbide.getItemStack(5))
                .buildAndRegister();

        // TODO - Is Boron Francium Carbide BaFrC?
        CHEMICAL_RECIPES.recipeBuilder().duration(260).EUt(980000)
                .inputs(FranciumCarbide.getItemStack(5))
                .inputs(BoronCarbide.getItemStack(5))
                .outputs(BoronFranciumCarbide.getItemStack())
                .buildAndRegister();

        // At + H2O + SO3 = [At + H2O + SO3]
        CHEMICAL_RECIPES.recipeBuilder().duration(240).EUt(640000)
                .input(dust, Astatine)
                .fluidInputs(Water.getFluid(1000))
                .fluidInputs(SulfurTrioxide.getFluid(1000))
                .fluidOutputs(AstatideSolution.getFluid(1000))
                .buildAndRegister();

        // 4[At + H2O + SO3] + Ho + Th + Cn + Fl = 4H2SO4 + [4At + Ho + Th + Cn + Fl]
        CHEMICAL_PLANT_RECIPES.recipeBuilder().duration(380).EUt(2000000)
                .fluidInputs(AstatideSolution.getFluid(4000))
                .input(dust, Holmium)
                .input(dust, Thulium)
                .input(dust, Copernicium)
                .input(dust, MetastableFlerovium)
                .fluidOutputs(SulfuricAcid.getFluid(4000))
                .outputs(MixedAstatideSalts.getItemStack())
                .buildAndRegister();

        // TODO What actually is Borocarbide??
        BLAST_RECIPES.recipeBuilder().duration(400).EUt(1300000).blastFurnaceTemp(10000)
                .inputs(BoronFranciumCarbide.getItemStack(2))
                .inputs(FranciumCarbide.getItemStack(2))
                .inputs(MixedAstatideSalts.getItemStack(2))
                .fluidInputs(Water.getFluid(2000))
                .outputs(BorocarbideDust.getItemStack())
                .fluidOutputs(FranciumAstatideSolution.getFluid(2000))
                .buildAndRegister();

        // TODO Corresponds with above
        ELECTROLYZER_RECIPES.recipeBuilder().duration(320).EUt(84000)
                .fluidInputs(FranciumAstatideSolution.getFluid(1000))
                .outputs(OreDictUnifier.get(dust, Francium))
                .outputs(OreDictUnifier.get(dust, Astatine))
                .buildAndRegister();

        // 6 I + 6[NaOH+H2O] = NaIO3 + 5 NaI + 3 H2O + 6 H2O
        ELECTROLYZER_RECIPES.recipeBuilder().duration(260).EUt(4000)
                .input(dust, Iodine, 6)
                .fluidInputs(SodiumHydroxideSolution.getFluid(6000))
                .outputs(SodiumIodate.getItemStack(5))
                .outputs(SodiumIodide.getItemStack(10))
                .fluidOutputs(Water.getFluid(9000))
                .buildAndRegister();

        // 3[Cu + H2SO4] + 6NaOH + NaI + 3SO3 = NaIO3 + 3Cu + 3NaSO4 + 6 H2O + 3SO2
        CHEMICAL_PLANT_RECIPES.recipeBuilder().duration(290).EUt(4900)
                .fluidInputs(CopperSulfateSolution.getFluid(3000))
                .fluidInputs(SulfurTrioxide.getFluid(3000))
                .inputs(SodiumIodide.getItemStack(2))
                .input(dust, SodiumHydroxide, 18)
                .outputs(SodiumIodate.getItemStack(5))
                .outputs(OreDictUnifier.get(dust, Copper, 3))
                .fluidOutputs(SodiumSulfateSolution.getFluid(3000))
                .fluidOutputs(Water.getFluid(3000))
                .fluidOutputs(SulfurDioxide.getFluid(3000))
                .buildAndRegister();

        // NaIO3 + NaClO = NaIO4 + NaCl
        LARGE_CHEMICAL_RECIPES.recipeBuilder().duration(340).EUt(3400)
                .inputs(SodiumIodate.getItemStack(5))
                .inputs(SodiumHypochlorite.getItemStack(3))
                .outputs(SodiumPeriodate.getItemStack(6))
                .outputs(OreDictUnifier.get(dust, Salt, 2))
                .buildAndRegister();

        // 2NaIO4 + 2Ru + 2NaOH + CO = 2NaI + 2Na2O4Ru + H2O + CO2 (Adjusted to 15Ru and 6Na2O4Ru to prevent infinite duping)
        LARGE_CHEMICAL_RECIPES.recipeBuilder().duration(220).EUt(680000)
                .inputs(SodiumPeriodate.getItemStack(12))
                .input(dust, Ruthenium, 15)
                .input(dust, SodiumHydroxide, 6)
                .fluidInputs(CarbonMonoxde.getFluid(1000))
                .outputs(SodiumIodide.getItemStack(4))
                .outputs(OreDictUnifier.get(dust, SodiumRuthenate, 6))
                .fluidOutputs(Water.getFluid(1000))
                .fluidOutputs(CarbonDioxide.getFluid(1000))
                .buildAndRegister();

        // Sg + NaOH + 5F + 2H2O = 5HF + NaSgO3
        LARGE_CHEMICAL_RECIPES.recipeBuilder().duration(320).EUt(720000)
                .input(dust, Seaborgium)
                .input(dust, SodiumHydroxide, 3)
                .fluidInputs(Fluorine.getFluid(5000))
                .fluidInputs(Water.getFluid(2000))
                .fluidOutputs(HydrofluoricAcid.getFluid(5000))
                .outputs(SodiumSeaborgate.getItemStack(5))
                .buildAndRegister();

        // Sr + 2Cl = SrCl2
        CHEMICAL_RECIPES.recipeBuilder().duration(320).EUt(1920)
                .input(dust, Strontium)
                .fluidInputs(Chlorine.getFluid(2000))
                .outputs(StrontiumChloride.getItemStack(3))
                .buildAndRegister();

        // Na2O4Ru + NaSgO3 + 2 SrCl2 + O = 3 NaCl + RuSgSr2O8 + Cl
        BLAST_RECIPES.recipeBuilder().duration(360).EUt(810000).blastFurnaceTemp(4500)
                .input(dust, SodiumRuthenate, 7)
                .inputs(SodiumSeaborgate.getItemStack(5))
                .inputs(StrontiumChloride.getItemStack(6))
                .fluidInputs(Oxygen.getFluid(1000))
                .outputs(OreDictUnifier.get(dust, Salt, 6))
                .outputs(StrontiumSuperconductorDust.getItemStack(12))
                .fluidOutputs(Chlorine.getFluid(1000))
                .buildAndRegister();

        // Os + 4O = OsO4
        BLAST_RECIPES.recipeBuilder().duration(520).EUt(4800).blastFurnaceTemp(1000)
                .input(dust, Osmium)
                .notConsumable(new IntCircuitIngredient(0))
                .fluidInputs(Oxygen.getFluid(4000))
                .outputs(OsmiumTetroxide.getItemStack(5))
                .buildAndRegister();

        // NaIO4 + C3H6O = NaIO3 + CH2O + C2H4O
        CHEMICAL_PLANT_RECIPES.recipeBuilder().duration(320).EUt(6000)
                .notConsumable(OsmiumTetroxide.getItemStack())
                .inputs(SodiumPeriodate.getItemStack(6))
                .fluidInputs(Acetone.getFluid(1000))
                .outputs(SodiumIodate.getItemStack(5))
                .fluidOutputs(Formaldehyde.getFluid(1000))
                .fluidOutputs(Acetaldehyde.getFluid(1000))
                .buildAndRegister();

        // C4H10 + 2Br = C4H9Br + HBr
        CHEMICAL_RECIPES.recipeBuilder().duration(280).EUt(5600)
                .notConsumable(UVA_HALIDE_LAMP.getStackForm())
                .fluidInputs(Butane.getFluid(1000))
                .fluidInputs(Bromine.getFluid(2000))
                .fluidOutputs(Bromobutane.getFluid(1000))
                .fluidOutputs(HydrobromicAcid.getFluid(1000))
                .buildAndRegister();

        // Ir + 2O = IrO2
        BLAST_RECIPES.recipeBuilder().duration(280).EUt(5000).blastFurnaceTemp(700)
                .notConsumable(dust, Salt)
                .input(dust, Iridium)
                .fluidInputs(Oxygen.getFluid(2000))
                .outputs(OreDictUnifier.get(dust, IridiumDioxide, 3))
                .buildAndRegister();

        // Kr + 2F = KrF2
        CHEMICAL_RECIPES.recipeBuilder().duration(270).EUt(7200)
                .notConsumable(UVA_HALIDE_LAMP.getStackForm())
                .fluidInputs(Krypton.getFluid(1000))
                .fluidInputs(Fluorine.getFluid(2000))
                .fluidOutputs(KryptonDifluoride.getFluid(1000))
                .buildAndRegister();

        // Mn + KrF2 = MnF2 + 2Kr
        CHEMICAL_RECIPES.recipeBuilder().duration(300).EUt(4900)
                .input(dust, Manganese)
                .fluidInputs(KryptonDifluoride.getFluid(1000))
                .outputs(ManganeseFluoride.getItemStack(3))
                .fluidOutputs(Krypton.getFluid(2000))
                .buildAndRegister();

        // MnF2 + O + H2O = MnO2 + 2HF
        CHEMICAL_RECIPES.recipeBuilder().duration(260).EUt(5200)
                .inputs(ManganeseFluoride.getItemStack(3))
                .fluidInputs(Water.getFluid(1000))
                .fluidInputs(Oxygen.getFluid(1000))
                .outputs(OreDictUnifier.get(dust, Pyrolusite, 3))
                .fluidOutputs(HydrofluoricAcid.getFluid(2000))
                .buildAndRegister();

                LARGE_CHEMICAL_RECIPES.recipeBuilder().duration(320).EUt(4200000) //C6H6O + H2O2 + 1 H2O + 2 Cl2 + 2 C2H2O -> C10H10O6 + 4 HCl
                .fluidInputs(Phenol.getFluid(1000))
                .fluidInputs(HydrogenPeroxide.getFluid(1000))
                .fluidInputs(Water.getFluid(3000))
                .fluidInputs(Chlorine.getFluid(4000))
                .fluidInputs(Ethenone.getFluid(2000))
                .fluidOutputs(PhenylenedioxydiaceticAcid.getFluid(1000))
                .fluidOutputs(HydrochloricAcid.getFluid(4000))
                .buildAndRegister();

        CHEMICAL_RECIPES.recipeBuilder().duration(210).EUt(420000) //NaSCN + HCl + 2 CH3CH2NH2 -> NH3 + (CH3CH2)2NCSNH2 + NaCl
                .fluidInputs(SodiumThiocyanate.getFluid(1000))
                .fluidInputs(HydrochloricAcid.getFluid(1000))
                .fluidInputs(Ethylamine.getFluid(2000))
                .fluidOutputs(Ammonia.getFluid(1000))
                .fluidOutputs(Diethylthiourea.getFluid(1000))
                .outputs(OreDictUnifier.get(dust, Salt, 2))
                .buildAndRegister();

        LARGE_CHEMICAL_RECIPES.recipeBuilder().duration(250).EUt(750000) //C10H10O6 + 2 (CH3CH2)2NCSNH2 + 2 SOCl2 -> 2SO2 + 4 HCl + C20H30N4O4S2
                .fluidInputs(Diethylthiourea.getFluid(2000))
                .fluidInputs(ThionylChloride.getFluid(2000))
                .fluidInputs(PhenylenedioxydiaceticAcid.getFluid(1000))
                .fluidOutputs(SulfurDioxide.getFluid(2000))
                .fluidOutputs(HydrochloricAcid.getFluid(4000))
                .fluidOutputs(Isophtaloylbisdiethylthiourea.getFluid(1000))
                .buildAndRegister();

        BLAST_RECIPES.recipeBuilder().duration(330).EUt(845000).blastFurnaceTemp(25000)
                .input(dust, MetastableHassium)
                .fluidInputs(Chlorine.getFluid(4000))
                .outputs(HassiumChloride.getItemStack(5))
                .buildAndRegister();

        BLAST_RECIPES.recipeBuilder().duration(330).EUt(845000).blastFurnaceTemp(25000)
                .input(dust, Rhenium)
                .fluidInputs(Chlorine.getFluid(5000))
                .outputs(RheniumChloride.getItemStack(6))
                .buildAndRegister();

        CHEMICAL_RECIPES.recipeBuilder().duration(280).EUt(50000) //SbF5 + PCl3 + HF -> SbCl3 + HPF6
                .fluidInputs(AntimonyPentafluoride.getFluid(1000))
                .fluidInputs(PhosphorusTrichloride.getFluid(1000))
                .fluidInputs(HydrofluoricAcid.getFluid(1000))
                .outputs(AntimonyTrichloride.getItemStack(4))
                .fluidOutputs(FluorophosphoricAcid.getFluid(1000))
                .buildAndRegister();

        CHEMICAL_RECIPES.recipeBuilder().duration(210).EUt(8400) //SbCl3 + 3 HF -> SbF3 + 3 HCl
                .inputs(AntimonyTrichloride.getItemStack(4))
                .fluidInputs(HydrofluoricAcid.getFluid(3000))
                .outputs(AntimonyTrifluoride.getItemStack(4))
                .fluidOutputs(HydrochloricAcid.getFluid(3000))
                .buildAndRegister();

        CHEMICAL_PLANT_RECIPES.recipeBuilder().duration(620).EUt(845000) //3 C20H30N4O4S2 + ReCl5 + HsCl4 + TlCl + HPF6 -> ReHsTlC60PN12H84S6O12F6 + 7 HCl + 3 Cl
                .inputs(RheniumChloride.getItemStack(6))
                .inputs(HassiumChloride.getItemStack(5))
                .inputs(ThalliumChloride.getItemStack(2))
                .fluidInputs(Isophtaloylbisdiethylthiourea.getFluid(3000))
                .fluidInputs(FluorophosphoricAcid.getFluid(1000))
                .outputs(RheniumHassiumThalliumIsophtaloylbisdiethylthioureaHexafluorophosphate.getItemStack(184))
                .fluidOutputs(HydrochloricAcid.getFluid(7000))
                .fluidOutputs(Chlorine.getFluid(3000))
                .buildAndRegister();

        LARGE_MIXER_RECIPES.recipeBuilder().duration(270).EUt(250000)
                .inputs(OreDictUnifier.get(dust, Naquadah),
                        OreDictUnifier.get(dust, NaquadahEnriched),
                        OreDictUnifier.get(dust, Naquadria),
                        OreDictUnifier.get(dust, Vibranium),
                        OreDictUnifier.get(dust, Adamantium),
                        OreDictUnifier.get(dust, Taranium),
                        OreDictUnifier.get(dust, Trinium),
                        OreDictUnifier.get(dust, Duranium),
                        OreDictUnifier.get(dust, Tritanium))
                .outputs(Legendarium.getItemStack(9))
                .buildAndRegister();

        CHEMICAL_PLANT_RECIPES.recipeBuilder().duration(520).EUt(845000)
                .input(dust, Cerium)
                .input(dust, Caesium)
                .input(dust, Cobalt, 2)
                .input(dust, Indium, 10)
                .fluidInputs(CosmicComputingMix.getFluid(2000))
                .outputs(ChargedCesiumCeriumCobaltIndium.getItemStack(16))
                .buildAndRegister();

        CHEMICAL_RECIPES.recipeBuilder().duration(290).EUt(320000)
                .fluidInputs(Cycloparaphenylene.getFluid(200))
                .fluidInputs(Methane.getFluid(800))
                .inputs(LanthanumEmbeddedFullerene.getItemStack())
                .notConsumable(plate, Rhenium)
                .outputs(LanthanumFullereneNanotubes.getItemStack())
                .buildAndRegister();
        
        LARGE_MIXER_RECIPES.recipeBuilder().duration(720).EUt(8500000)
                .input(dust, BlackTitanium, 3)
                .input(dust, SuperheavyHAlloy, 2)
                .inputs(ChargedCesiumCeriumCobaltIndium.getItemStack(3))
                .inputs(RheniumHassiumThalliumIsophtaloylbisdiethylthioureaHexafluorophosphate.getItemStack(6))
                .outputs(OreDictUnifier.get(dust, UMVSuperconductorBase, 14))
                .buildAndRegister();
        
        
        LARGE_MIXER_RECIPES.recipeBuilder().duration(720).EUt(33500000)
                .inputs(Legendarium.getItemStack(5))
                .input(dust, Neutronium, 4)
                .inputs(ActiniumSuperhydride.getItemStack(5))
                .inputs(LanthanumFullereneNanotubes.getItemStack(4))
                .inputs(RheniumHassiumThalliumIsophtaloylbisdiethylthioureaHexafluorophosphate.getItemStack(12))
                .outputs(OreDictUnifier.get(dust, UXVSuperconductorBase, 30))
                .buildAndRegister();

        // 2La + H2SO4 = La2O3 + Dilute Sulfuric
        CHEMICAL_RECIPES.recipeBuilder().duration(100).EUt(480)
                .input(dust, Lanthanum, 2)
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .outputs(LanthanumOxide.getItemStack(5))
                .fluidOutputs(DilutedSulfuricAcid.getFluid(1000))
                .buildAndRegister();
    }
}
