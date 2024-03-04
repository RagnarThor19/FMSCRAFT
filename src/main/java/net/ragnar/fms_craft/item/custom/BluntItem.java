package net.ragnar.fms_craft.item.custom;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public class BluntItem extends Item {
    public BluntItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, net.minecraft.world.InteractionHand pHand) {
        // Start using the item and play the breathing sound effect
        pPlayer.startUsingItem(pHand);
        pLevel.playSound(null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SoundEvents.PLAYER_BREATH, pPlayer.getSoundSource(), 1.0F, 1.0F);
        return InteractionResultHolder.consume(pPlayer.getItemInHand(pHand));
    }



    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, Player pPlayer) {
        // Apply the levitation effect on the server side
        if (!pLevel.isClientSide) {
            pPlayer.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 300, 3)); // 200 ticks with amplifier 1
        }

        // Consume the item unless the player is in creative mode
        if (!pPlayer.getAbilities().instabuild) {
            pStack.shrink(1);
        }

        return pStack;
    }

    @Override
    public int getUseDuration(ItemStack pStack) {
        return 32; // Time to use/eat the item
    }

    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.DRINK; // Eating animation
    }
}
