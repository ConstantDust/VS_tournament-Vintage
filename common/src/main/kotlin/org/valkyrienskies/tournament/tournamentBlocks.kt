package org.valkyrienskies.tournament

import net.minecraft.core.Registry
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import org.valkyrienskies.tournament.block.*
import org.valkyrienskies.tournament.item.blockitem.ThrusterBlockItem
import org.valkyrienskies.tournament.registry.DeferredRegister

@Suppress("unused")
object tournamentBlocks {
    private val BLOCKS = DeferredRegister.create(tournamentMod.MOD_ID, Registry.BLOCK_REGISTRY)

    private var no_tab = ArrayList<String>()
    private var tier_sets = ArrayList<String>()

    val BALLAST     = BLOCKS.register("ballast", ::BallastBlock)
    val BALLOON     = BLOCKS.register("balloon", ::BalloonBlock)
    val THRUSTER    = BLOCKS.register("thruster", ::ThrusterBlock)
    val SPINNER     = BLOCKS.register("spinner", ::SpinnerBlock)
    val SHIPIFIER   = BLOCKS.register("shipifier", ::ShipifierBlock,)
    val HINGE       = BLOCKS.register("hinge", ::HingeBlock)
    val HINGE_TOP   = BLOCKS.register("hinge_top", ::HingeTopBlock)
    val SENSOR        = BLOCKS.register("sensor", ::SensorBlock)
    val SEAT        = BLOCKS.register("seat", ::SeatBlock)

    fun register() {
        no_tab.add("hinge_top")

        tier_sets.add("thruster")

        BLOCKS.applyAll()
    }

    fun registerItems(items: DeferredRegister<Item>) {
        BLOCKS.forEach {
            if (it.name in tier_sets) {
                //i know thats bad code but it works
                if (it.name in no_tab) {
                    items.register(it.name+"_1") { ThrusterBlockItem(it.get(), Item.Properties()) }
                    items.register(it.name+"_2") { ThrusterBlockItem(it.get(), Item.Properties()) }
                    items.register(it.name+"_3") { ThrusterBlockItem(it.get(), Item.Properties()) }
                    items.register(it.name+"_4") { ThrusterBlockItem(it.get(), Item.Properties()) }
                    items.register(it.name+"_5") { ThrusterBlockItem(it.get(), Item.Properties()) }
                } else {
                    items.register(it.name+"_1") { ThrusterBlockItem(it.get(), Item.Properties().tab(tournamentItems.TAB)) }
                    items.register(it.name+"_2") { ThrusterBlockItem(it.get(), Item.Properties().tab(tournamentItems.TAB)) }
                    items.register(it.name+"_3") { ThrusterBlockItem(it.get(), Item.Properties().tab(tournamentItems.TAB)) }
                    items.register(it.name+"_4") { ThrusterBlockItem(it.get(), Item.Properties().tab(tournamentItems.TAB)) }
                    items.register(it.name+"_5") { ThrusterBlockItem(it.get(), Item.Properties().tab(tournamentItems.TAB)) }
                }
            } else {
                if (it.name in no_tab) {
                    items.register(it.name) { BlockItem(it.get(), Item.Properties()) }
                } else {
                    items.register(it.name) { BlockItem(it.get(), Item.Properties().tab(tournamentItems.TAB)) }
                }
            }
        }
    }

}
