package net.wjka.dnm.item.Dice;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.wjka.dnm.GUI.CustomPopupScreen;


public class NegativeDice extends Item {



    DiceRoll dR = new DiceRoll();

    public NegativeDice(Settings settings) {
        super(settings);
    }


    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if (!world.isClient && world instanceof ServerWorld) {
            ServerWorld serverWorld = (ServerWorld)world;
            // Pass serverWorld to the RollDice method
            dR.RollDice("dice_negative", serverWorld, user);
        }
        if (world.isClient) {
            CustomPopupScreen cps = new CustomPopupScreen(Text.literal("hi mum"));
            MinecraftClient.getInstance().setScreen(cps); // This line will display your custom screen
        }
        return new TypedActionResult<>(ActionResult.SUCCESS, itemStack);
    }



}
