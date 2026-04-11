package reapermod.cards.uncommon;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.utility.ScryAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import reapermod.cards.BaseCard;
import reapermod.character.TheReaper;
import reapermod.util.CardStats;

public class TheForetoldCrow extends BaseCard {
    public static final String ID = makeID("TheForetoldCrow"); //makeID adds the mod ID, so the final ID will be something like "modID:MyCard"
    private static final CardStats info = new CardStats (
            TheReaper.Meta.CARD_COLOR, //The card color. If you're making your own character, it'll look something like this. Otherwise, it'll be CardColor.RED or similar for a basegame character color.
            CardType.SKILL, //The type. ATTACK/SKILL/POWER/CURSE/STATUS
            CardRarity.UNCOMMON, //Rarity. BASIC is for starting cards, then there's COMMON/UNCOMMON/RARE, and then SPECIAL and CURSE. SPECIAL is for cards you only get from events. Curse is for curses, except for special curses like Curse of the Bell and Necronomicurse.
            CardTarget.SELF, //The target. Single target is ENEMY, all enemies is ALL_ENEMY. Look at cards similar to what you want to see what to use.
            1 //The card's base cost. -1 is X cost, -2 is no cost for unplayable cards like curses, or Reflex.
    );
    //These will be used in the constructor. Technically you can just use the values directly,
    //but constants at the top of the file are easy to adjust.
    private static final int SCRY = 2;
    private static final int  DRAW = 1;
    private static final boolean EXHAUST = true;
    private static final boolean UPG_EXHAUST = false;

    public TheForetoldCrow() {
        super(ID, info); //Pass the required information to the BaseCard constructor.
        setExhaust(EXHAUST, UPG_EXHAUST);
    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ScryAction(SCRY));
        addToBot(new DrawCardAction(DRAW));
//        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SLASH_VERTICAL));
    }
    @Override
    public AbstractCard makeCopy() { //Optional
        return new TheForetoldCrow();
    }
}
