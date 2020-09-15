package com.snowmantheater.warden;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PredicateActionsTest {
    private final static RejectionMessages MESSAGES = RejectionMessages.of(1);
    private final static String BASIC_MESSAGE = "Rejecting '1'.";

    private final static String REASON = "reason";
    private final static String REASON_MESSAGE = "Rejecting '1': reason";

    private final static Exception CAUSE = new Exception("message");
    private final static String CAUSE_MESSAGE = "Rejecting '1': message";

    // -----------------------------------------------------------------------------------------------------------------
    //                                                                                                      CONSTRUCTORS

    @Test
    @DisplayName("Calling matching(null, null) throws NPE")
    public void calling_matching_w_null_and_null_throws_NPE() {
        assertThrows(
            NullPointerException.class,
            () -> PredicateActions.matching(null, null)
        );
    }

    @Test
    @DisplayName("Calling notMatching(null, null) throws NPE")
    public void calling_notMatching_w_null_and_null_throws_NPE() {
        assertThrows(
            NullPointerException.class,
            () -> PredicateActions.notMatching(null, null)
        );
    }

    @Test
    @DisplayName("Calling matching(null, Messages) returns PredicateActions")
    public void calling_matching_w_null_and_Messages_returns_PredicateActions() {
        PredicateActions actions = PredicateActions.matching(null, MESSAGES);
        assertNotNull(actions);
    }

    @Test
    @DisplayName("Calling notMatching(null, Messages) returns PredicateActions")
    public void calling_notMatching_w_null_and_Messages_returns_PredicateActions() {
        PredicateActions actions = PredicateActions.notMatching(null, MESSAGES);
        assertNotNull(actions);
    }

    // -----------------------------------------------------------------------------------------------------------------
    //                                                                                                      isMatching()

    @Test
    @DisplayName("Calling matching().isMatching() returns true")
    public void calling_matching_isMatching_returns_true() {
        PredicateActions actions = PredicateActions.matching(1, MESSAGES);
        assertTrue(actions.isMatching());
    }

    @Test
    @DisplayName("Calling notMatching().isMatching() returns false")
    public void calling_notMatching_isMatching_returns_false() {
        PredicateActions actions = PredicateActions.notMatching(1, MESSAGES);
        assertFalse(actions.isMatching());
    }

    // -----------------------------------------------------------------------------------------------------------------
    //                                                                                                          reject()

    @Test
    @DisplayName("Calling matching().reject() throws RejectionException")
    public void calling_matching_reject_throws_RejectionException() {
        PredicateActions actions = PredicateActions.matching(1, MESSAGES);

        try{
            actions.reject();
            fail("actions.reject() should throw RejectionException");
        } catch(RejectionException e) {
            assertEquals(BASIC_MESSAGE, e.getMessage());
        }
    }

    @Test
    @DisplayName("Calling notMatching().reject() NoOp")
    public void calling_notMatching_reject_NoOp() {
        PredicateActions actions = PredicateActions.notMatching(1, MESSAGES);
        assertDoesNotThrow(actions::reject);
    }

    // -----------------------------------------------------------------------------------------------------------------
    //                                                                                                      rejectWith()

    @Test
    @DisplayName("Calling matching().rejectWith(null) throws NPE")
    public void calling_matching_rejectWith_w_null_throws_NPE() {
        PredicateActions actions = PredicateActions.matching(1, MESSAGES);

        assertThrows(
            NullPointerException.class,
            () -> actions.rejectWith(null)
        );
    }

    @Test
    @DisplayName("Calling notMatching().rejectWith(null) NoOp")
    public void calling_notMatching_rejectWith_w_null_NoOp() {
        PredicateActions actions = PredicateActions.notMatching(1, MESSAGES);
        assertDoesNotThrow(() -> actions.rejectWith(null));
    }

    @Test
    @DisplayName("Calling matching().rejectWith(String) throws RejectionException")
    public void calling_matching_rejectWith_w_String_throws_RejectionException() {
        PredicateActions actions = PredicateActions.matching(1, MESSAGES);

        try{
            actions.rejectWith(REASON);
            fail("actions.reject() should throw RejectionException");
        } catch(RejectionException e) {
            assertEquals(REASON_MESSAGE, e.getMessage());
        }
    }

    @Test
    @DisplayName("Calling notMatching().rejectWith(String) NoOp")
    public void calling_notMatching_rejectWith_w_String_NoOp() {
        PredicateActions actions = PredicateActions.notMatching(1, MESSAGES);
        assertDoesNotThrow(() -> actions.rejectWith(REASON));
    }

    // -----------------------------------------------------------------------------------------------------------------
    //                                                                                                       rejectFor()

    @Test
    @DisplayName("Calling matching().rejectFor(null) throws NPE")
    public void calling_matching_rejectFor_w_null_throws_NPE() {
        PredicateActions actions = PredicateActions.matching(1, MESSAGES);

        assertThrows(
            NullPointerException.class,
            () -> actions.rejectFor(null)
        );
    }

    @Test
    @DisplayName("Calling notMatching().rejectFor(null) NoOp")
    public void calling_notMatching_rejectFor_w_null_NoOp() {
        PredicateActions actions = PredicateActions.notMatching(1, MESSAGES);
        assertDoesNotThrow(() -> actions.rejectFor(null));
    }

    @Test
    @DisplayName("Calling matching().rejectFor(Exception) throws RejectionException")
    public void calling_matching_rejectFor_w_Exception_throws_RejectionException() {
        PredicateActions actions = PredicateActions.matching(1, MESSAGES);

        try{
            actions.rejectFor(CAUSE);
            fail("actions.reject() should throw RejectionException");
        } catch(RejectionException e) {
            assertEquals(CAUSE_MESSAGE, e.getMessage());
            assertEquals(CAUSE, e.getCause());
        }
    }

    @Test
    @DisplayName("Calling notMatching().rejectFor(Exception) NoOp")
    public void calling_notMatching_rejectFor_w_Exception_NoOp() {
        PredicateActions actions = PredicateActions.notMatching(1, MESSAGES);
        assertDoesNotThrow(() -> actions.rejectFor(CAUSE));
    }

    // -----------------------------------------------------------------------------------------------------------------
    //                                                                                                          accept()

    @Test
    @DisplayName("Calling matching().accept() NoOp")
    public void calling_matching_accept_NoOp() {
        PredicateActions actions = PredicateActions.matching(1, MESSAGES);

        assertDoesNotThrow(actions::accept);
    }

    @Test
    @DisplayName("Calling notMatching().reject() throws RejectionException")
    public void calling_notMatching_accept_throws_RejectionException() {
        PredicateActions actions = PredicateActions.notMatching(1, MESSAGES);

        try{
            actions.accept();
            fail("actions.accept() should throw RejectionException");
        } catch(RejectionException e) {
            assertEquals(BASIC_MESSAGE, e.getMessage());
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    //                                                                                                       rejectFor()

    @Test
    @DisplayName("Calling matching().raise(null) throws NPE")
    public void calling_matching_raise_w_null_throws_NPE() {
        PredicateActions actions = PredicateActions.matching(1, MESSAGES);

        assertThrows(
            NullPointerException.class,
            () -> actions.raise(null)
        );
    }

    @Test
    @DisplayName("Calling notMatching().raise(null) NoOp")
    public void calling_notMatching_raise_w_null_NoOp() {
        PredicateActions actions = PredicateActions.notMatching(1, MESSAGES);
        assertDoesNotThrow(() -> actions.raise(null));
    }

    @Test
    @DisplayName("Calling matching().raise(Supplier) throws Exception")
    public void calling_matching_raise_w_Supplier_throws_Exception() {
        PredicateActions actions = PredicateActions.matching(1, MESSAGES);

        try{
            actions.raise(() -> CAUSE);
            fail("actions.raise() should throw RejectionException");
        } catch(Exception e) {
            assertEquals(CAUSE, e);
        }
    }

    @Test
    @DisplayName("Calling notMatching().raise(Supplier) NoOp")
    public void calling_notMatching_raise_w_Supplier_NoOp() {
        PredicateActions actions = PredicateActions.notMatching(1, MESSAGES);
        assertDoesNotThrow(() -> actions.raise(() -> CAUSE));
    }
}