package gregicadditions.jei.multi.simple;

import com.google.common.collect.Lists;
import gregicadditions.GAValues;
import gregicadditions.item.GAMetaBlocks;
import gregicadditions.machines.GATileEntities;
import gregicadditions.machines.multi.simple.TileEntityLargeBenderAndForming;
import gregtech.api.metatileentity.multiblock.MultiblockControllerBase;
import gregtech.common.blocks.BlockBoilerCasing;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.metatileentities.MetaTileEntities;
import gregtech.integration.jei.multiblock.MultiblockInfoPage;
import gregtech.integration.jei.multiblock.MultiblockShapeInfo;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;

import java.util.ArrayList;
import java.util.List;

public class LargeBenderAndFormingInfo extends MultiblockInfoPage {
    @Override
    public MultiblockControllerBase getController() {
        return GATileEntities.LARGE_BENDER_AND_FORMING;
    }

    @Override
    public List<MultiblockShapeInfo> getMatchingShapes() {
        ArrayList<MultiblockShapeInfo> shapeInfo = new ArrayList<>();
        for (int i = 2; i < 9; i++) {
            MultiblockShapeInfo.Builder builder = MultiblockShapeInfo.builder()
                    .aisle("XXXX", "XXXX", "XXIX");
            for (int j = 0; j < i; j++) {
                builder.aisle("iXXX", "XPMX", "XXIO");
            }
            builder.aisle("EXXX", "XSHX", "XXIX")
                    .where('E', MetaTileEntities.ENERGY_INPUT_HATCH[GAValues.HV], EnumFacing.NORTH)
                    .where('S', GATileEntities.LARGE_BENDER_AND_FORMING, EnumFacing.SOUTH)
                    .where('H', GATileEntities.MAINTENANCE_HATCH[0], EnumFacing.SOUTH)
                    .where('X', TileEntityLargeBenderAndForming.casingState)
                    .where('#', Blocks.AIR.getDefaultState())
                    .where('i', MetaTileEntities.ITEM_IMPORT_BUS[GAValues.LV], EnumFacing.WEST)
                    .where('O', MetaTileEntities.ITEM_EXPORT_BUS[GAValues.LV], EnumFacing.EAST)
                    .where('M', GAMetaBlocks.MOTOR_CASING.getDefaultState())
                    .where('P', GAMetaBlocks.PISTON_CASING.getDefaultState())
                    .where('I', MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.TITANIUM_PIPE));
            shapeInfo.add(builder.build());
        }

        return Lists.newArrayList(shapeInfo);
    }

	@Override
	public String[] getDescription() {
		return new String[]{"Temporary Placeholder"};
	}
}
