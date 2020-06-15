package gregicadditions.jei.multi.simple;

import com.google.common.collect.Lists;
import gregicadditions.item.GAMetaBlocks;
import gregicadditions.item.GAMultiblockCasing;
import gregicadditions.machines.GATileEntities;
import gregtech.api.GTValues;
import gregtech.api.metatileentity.multiblock.MultiblockControllerBase;
import gregtech.common.blocks.BlockWireCoil;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.metatileentities.MetaTileEntities;
import gregtech.integration.jei.multiblock.MultiblockInfoPage;
import gregtech.integration.jei.multiblock.MultiblockShapeInfo;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;

import java.util.ArrayList;
import java.util.List;

public class LargeAssemblerInfo extends MultiblockInfoPage {
    @Override
    public MultiblockControllerBase getController() {
        return GATileEntities.LARGE_ASSEMBLER;
    }

    @Override
    public List<MultiblockShapeInfo> getMatchingShapes() {
        ArrayList<MultiblockShapeInfo> shapeInfo = new ArrayList<>();
        for (BlockWireCoil.CoilType coilType : BlockWireCoil.CoilType.values()) {
            shapeInfo.add(MultiblockShapeInfo.builder()
                    .aisle("XXX", "XXX", "XXX")
                    .aisle("IXX", "X#X", "XXX")
                    .aisle("OEX", "XSX", "XXX")
                    .where('E', MetaTileEntities.ENERGY_INPUT_HATCH[GTValues.HV], EnumFacing.WEST)
                    .where('S', GATileEntities.LARGE_ASSEMBLER, EnumFacing.SOUTH)
                    .where('C', MetaBlocks.WIRE_COIL.getState(coilType))
                    .where('X', GAMetaBlocks.MUTLIBLOCK_CASING.getState(GAMultiblockCasing.CasingType.LARGE_ASSEMBLER))
                    .where('#', Blocks.AIR.getDefaultState())
                    .where('I', MetaTileEntities.ITEM_IMPORT_BUS[GTValues.LV], EnumFacing.WEST)
                    .where('O', MetaTileEntities.ITEM_EXPORT_BUS[GTValues.LV], EnumFacing.WEST)
                    .build());
        }

        return Lists.newArrayList(shapeInfo);
    }

    @Override
    public String[] getDescription() {
        return new String[]{};
    }
}
