package net.kinglybugle.kaglic.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.kinglybugle.kaglic.Kaglic;
import net.kinglybugle.kaglic.block.entity.CoalGeneratorBlockEntity;
import net.kinglybugle.kaglic.screen.renderer.EnergyInfoArea;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import org.jetbrains.annotations.NotNull;

public class CoalGeneratorScreen extends AbstractContainerScreen<CoalGeneratorMenu> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(Kaglic.MOD_ID, "textures/gui/container/coal_generator_gui.png");
    private EnergyInfoArea energyInfoArea;

    public CoalGeneratorScreen(CoalGeneratorMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
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
    public void renderBg(@NotNull GuiGraphics pGuiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
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
            guiGraphics.blit(TEXTURE, x + 71, y + 32, 176, 0, menu.getScaledProgress() + 1, 16);
        }
    }
    // (Start) CREDIT TO MCJTY
    private static final int ENERGY_LEFT = 146;
    private static final int ENERGY_TOP = 11;
    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, delta);
        renderTooltip(guiGraphics, mouseX, mouseY);
        energyInfoArea.draw(guiGraphics.pose());

        CoalGeneratorBlockEntity blockEntity = menu.getBlockEntity();

        if (mouseX >= leftPos + ENERGY_LEFT && mouseX < leftPos + ENERGY_LEFT + 16 &&
                mouseY >= topPos + ENERGY_TOP && mouseY < topPos + ENERGY_TOP + 65) {
            int power = blockEntity.getEnergyStorage().getEnergyStored();
            guiGraphics.renderTooltip(this.font, Component.literal(power + " FE"), mouseX, mouseY);
        }
    }
    // (End) CREDIT TO MCJTY
}
