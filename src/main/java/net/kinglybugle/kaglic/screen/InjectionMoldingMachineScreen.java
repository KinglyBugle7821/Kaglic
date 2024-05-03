package net.kinglybugle.kaglic.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import net.kinglybugle.kaglic.Kaglic;
import net.kinglybugle.kaglic.block.entity.InjectionMoldingMachineBlockEntity;
import net.kinglybugle.kaglic.screen.renderer.EnergyInfoArea;
import net.kinglybugle.kaglic.util.MouseUtil;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipPositioner;
import net.minecraft.client.gui.screens.inventory.tooltip.DefaultTooltipPositioner;
import net.minecraft.client.gui.screens.inventory.tooltip.TooltipRenderUtil;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.ItemStack;
import org.joml.Matrix4f;
import org.joml.Vector2ic;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class InjectionMoldingMachineScreen extends AbstractContainerScreen<InjectionMoldingMachineMenu> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(Kaglic.MOD_ID, "textures/gui/container/injection_molding_machine_gui.png");
    private EnergyInfoArea energyInfoArea;

    public InjectionMoldingMachineScreen(InjectionMoldingMachineMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }




    @Override
    protected void init() {
        super.init();
        this.inventoryLabelY = 10000;
        this.titleLabelY = 10000;
        assignEnergyInfoArea();
    }

    private void assignEnergyInfoArea() {
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;
        energyInfoArea = new EnergyInfoArea(x + 146, y + 11, menu.blockEntity.getEnergyStorage());
    }

    @Override
    protected void renderBg(GuiGraphics pGuiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        pGuiGraphics.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight);

        renderProgressArrow(pGuiGraphics, x, y);
        energyInfoArea.draw(pGuiGraphics.pose());
    }
    private void renderProgressArrow(GuiGraphics guiGraphics, int x, int y) {
        if(menu.isCrafting()) {
            guiGraphics.blit(TEXTURE, x + 102, y + 14, 176, 0, 8, menu.getScaledProgress());
        }
    }
    private static final int ENERGY_LEFT = 146;
    private static final int ENERGY_TOP = 11;
    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {

        renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, delta);
        renderTooltip(guiGraphics, mouseX, mouseY);

        InjectionMoldingMachineBlockEntity blockEntity = menu.getBlockEntity();

        if (mouseX >= leftPos + ENERGY_LEFT && mouseX < leftPos + ENERGY_LEFT + 16 &&
                mouseY >= topPos + ENERGY_TOP && mouseY < topPos + ENERGY_TOP + 65) {
            int power = blockEntity.getEnergyStorage().getEnergyStored();
            guiGraphics.renderTooltip(this.font, Component.literal(power + " FE"), mouseX, mouseY);
        }
    }
}
