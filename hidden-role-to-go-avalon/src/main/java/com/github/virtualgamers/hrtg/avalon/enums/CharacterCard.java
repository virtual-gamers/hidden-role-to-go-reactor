package com.github.virtualgamers.hrtg.avalon.enums;

import java.util.Arrays;
import java.util.List;
import com.github.virtualgamers.hrtg.avalon.model.KnowledgeRole;

public enum CharacterCard {
    // Good
    LOYAL_SERVANT(Alignment.GOOD), //
    MERLIN(Alignment.GOOD), //
    PERCIVAL(Alignment.GOOD), //

    // Evil
    ASSASSIN(Alignment.EVIL), //
    MINION_OF_MORDRED(Alignment.EVIL), //
    MORDRED(Alignment.EVIL), //
    MORGANA(Alignment.EVIL), //
    OBRYN(Alignment.EVIL),

    // Expansion & Homebrew Content
    GUINEVERE(Alignment.GOOD), //
    LANCELOT_BAD(Alignment.EVIL), //
    LANCELOT_GOOD(Alignment.GOOD), //
    LOVER(Alignment.GOOD), //
    SIR_KAY(Alignment.GOOD);

    private final Alignment alignment;

    private CharacterCard(final Alignment alignment) {
        this.alignment = alignment;
    }

    public Alignment getAlignment() {
        return alignment;
    }

    public List<KnowledgeRole> getRoleKnowledge() {
        switch (this) {
            // Evil
            case ASSASSIN:
            case MINION_OF_MORDRED:
            case MORDRED:
            case MORGANA:
                return Arrays.asList( //
                        new KnowledgeRole(ASSASSIN, Knowledge.ALL), //
                        new KnowledgeRole(MINION_OF_MORDRED, Knowledge.ALL), //
                        new KnowledgeRole(MORDRED, Knowledge.ALL), //
                        new KnowledgeRole(MORGANA, Knowledge.ALL), //
                        new KnowledgeRole(OBRYN, Knowledge.ALL));
            case LOVER:
                return Arrays.asList(new KnowledgeRole(LOVER, Knowledge.ALL));
            case MERLIN:
                return Arrays.asList( //
                        new KnowledgeRole(ASSASSIN, Knowledge.ALIGNMENT), //
                        new KnowledgeRole(MINION_OF_MORDRED, Knowledge.ALIGNMENT), //
                        new KnowledgeRole(MORGANA, Knowledge.ALIGNMENT), //
                        new KnowledgeRole(OBRYN, Knowledge.ALIGNMENT), //
                        new KnowledgeRole(SIR_KAY, Knowledge.ALIGNMENT));
            case PERCIVAL:
                return Arrays.asList( //
                        new KnowledgeRole(MERLIN, Knowledge.ALIGNMENT), //
                        new KnowledgeRole(MORGANA, Knowledge.ALIGNMENT));
            // Guinevere & Lancelot
            case GUINEVERE:
                return Arrays.asList( //
                        new KnowledgeRole(LANCELOT_BAD, Knowledge.ALIGNMENT), //
                        new KnowledgeRole(LANCELOT_GOOD, Knowledge.ALIGNMENT));
            default:
                // A Role Knows Nothing
                return Arrays.asList();
        }
    }
}
