package moe.plushie.armourers_workshop.init;

import moe.plushie.armourers_workshop.core.data.slot.ItemMatcher;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.function.Predicate;

@SuppressWarnings("unused")
public class ModItemMatchers {

    public static final ItemMatcher SWORDS = MatcherBuilder.of()
            .match("sword")
            .match("machete")
            .match("gladius")
            .match("falchion")
            .match("saber")
            .match("cullass")
            .match("rapier")
            .match("dao")
            .match("jian")
            .match("odachi")
            .match("wakizashi")
            .match("katana")
            .match("chokuto")
            .match("ninjato")
            .match("scimitar")
            .match("shamshir")
            // 添加排除项，避免与新类型冲突
            .nonMatch("greatsword")
            .nonMatch("claymore")
            .nonMatch("flamberge")
            .nonMatch("zweihander")
            .nonMatch("longsword")
            .nonMatch("dagger")
            .nonMatch("kunai")
            .nonMatch("shuriken")
            .nonMatch("tachi")
            .build();

    public static final ItemMatcher TRIDENTS = MatcherBuilder.of()
            .match("trident")
            .match("lance")
            .match("halbred")
            .nonMatch("spear")
            .build();

    public static final ItemMatcher SHIELDS = MatcherBuilder.of()
            .match("shield")
            .build();

    public static final ItemMatcher BOWS = MatcherBuilder.of()
            .match("bow")
            .nonMatch("bowl")
            .build();

    public static final ItemMatcher PICKAXES = MatcherBuilder.of()
            .match("pickaxe")
            .build();

    public static final ItemMatcher AXES = MatcherBuilder.of()
            .match("axe")
            .nonMatch("pickaxe")
            .nonMatch("waxed")
            .build();

    public static final ItemMatcher SHOVELS = MatcherBuilder.of()
            .match("shovel")
            .build();

    public static final ItemMatcher HOES = MatcherBuilder.of()
            .match("hoe")
            .build();

    public static final ItemMatcher GREATSWORDS = MatcherBuilder.of()
            .match("greatsword")
            .match("claymore")
            .match("flamberge")
            .match("zweihander")
            .build();

    public static final ItemMatcher SPEARS = MatcherBuilder.of()
            .match("spear")
            .match("lance")
            .match("pike")
            .build();

    public static final ItemMatcher TACHIS = MatcherBuilder.of()
            .match("tachi")
            .build();

    public static final ItemMatcher LONGSWORDS = MatcherBuilder.of()
            .match("longsword")
            .build();

    public static final ItemMatcher DAGGERS = MatcherBuilder.of()
            .match("dagger")
            .match("kunai")
            .match("shuriken")
            .build();

    public static final ItemMatcher GLOVES = MatcherBuilder.of()
            .match("glove")
            .match("gauntlet")
            .build();

    private static class MatcherBuilder {

        private final StringBuffer mathBuffer = new StringBuffer();
        private final StringBuffer nonMathBuffer = new StringBuffer();

        private final ArrayList<String> whitelist = new ArrayList<>();
        private final ArrayList<String> blacklist = new ArrayList<>();

        private Predicate<ItemStack> requirements;

        private static MatcherBuilder of() {
            return new MatcherBuilder();
        }

        private MatcherBuilder match(String tag) {
            if (mathBuffer.length() != 0) {
                mathBuffer.append("|");
            }
            mathBuffer.append(tag);
            return this;
        }

        private MatcherBuilder nonMatch(String tag) {
            if (nonMathBuffer.length() != 0) {
                nonMathBuffer.append("|");
            }
            nonMathBuffer.append(tag);
            return this;
        }

        private MatcherBuilder add(String tag) {
            whitelist.add(tag);
            return this;
        }

        private MatcherBuilder remove(String tag) {
            blacklist.add(tag);
            return this;
        }

        private ItemMatcher build() {
            return new ItemMatcher(mathBuffer.toString(), nonMathBuffer.toString(), whitelist, blacklist, requirements);
        }
    }
}
