package ru.job4j.bank;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
/**
 * тест класса банковских переводов.
 * @author Dmitry Ilyshev (dilyshev@mac.com)
 * @version $Id$
 * @since 0.1
 */
public class BankTest {
    /**
     * тест добавления пользователя.
     */
    @Test
    public void whenAddUserThenAdd() {
        Bank bank = new Bank();
        User john = new User("John", "6555502");
        bank.addUser(john);
        assertThat(bank.containsUser(john), is(true));
    }

    /**
     * тест удаления пользователя.
     */
    @Test
    public void whenDeleteUserThenDelete() {
        Bank bank = new Bank();
        User john = new User("John", "6555502");
        bank.addUser(john);
        assertThat(bank.containsUser(john), is(true));
        bank.deleteUser(john);
        assertThat(bank.containsUser(john), is(false));
    }

    /**
     * тест добавления счета пользователю.
     */
    @Test
    public void whenAddAccountToUserThenAddAcc() {
        Bank bank = new Bank();
        User john = new User("John", "6555502");
        bank.addUser(john);
        Account johnAcc = new Account(1000, "2055556");
        bank.addAccountToUser("6555502", johnAcc);
        List<Account> result = bank.getUserAccounts(john.getPassport());
        assertThat(result.get(0).getRequisites(), is(johnAcc.getRequisites()));
    }

    /**
     * тест удаления счета у пользователя.
     */
    @Test
    public void deleteAccountFromUser() {
        Bank bank = new Bank();
        User john = new User("John", "6555502");
        bank.addUser(john);
        Account johnAcc = new Account(1000, "2055556");
        bank.addAccountToUser(john.getPassport(), johnAcc);
        bank.deleteAccountFromUser("6555502", johnAcc);
        assertThat(bank.getUserAccounts("6555502").size(), is(0));
    }

    /**
     * тест получения списка счетов пользователя.
     */
    @Test
    public void getUserAccounts() {
        Bank bank = new Bank();
        User john = new User("John", "6555502");
        bank.addUser(john);
        Account johnAcc1 = new Account(1000, "2055556");
        bank.addAccountToUser(john.getPassport(), johnAcc1);
        Account johnAcc2 = new Account(500, "3055556");
        bank.addAccountToUser(john.getPassport(), johnAcc2);
        List<Account> result = bank.getUserAccounts(john.getPassport());
        List<Account> expect = Arrays.asList(johnAcc1, johnAcc2);
        assertThat(result, is(expect));
    }
    /**
     * тест на возможность переслать деньги одному пользователю от другого.
     */
    @Test
    public void whenTwoUsersHaveAccountsThenTransferFromOneToAnother() {
        Bank bank = new Bank();
        User john = new User("John", "6555502");
        bank.addUser(john);
        Account johnAcc = new Account(1000, "2055556");
        bank.addAccountToUser("6555502", johnAcc);
        User martin = new User("Martin", "6555503");
        bank.addUser(martin);
        Account martinAcc = new Account(500, "3055556");
        bank.addAccountToUser("6555503", martinAcc);
        boolean result = bank.transferMoney("6555502", "2055556", "6555503", "3055556", 500);
        assertThat(result, is(true));
    }
    /**
     * тест на невозможность переслать деньги одному пользователю от другого, если у первого на счету меньше запрошенной суммы.
     */
    @Test
    public void whenFirstUserHasNotEnoughValueForTransferToOtherUserThenTransferFalse() {
        Bank bank = new Bank();
        User john = new User("John", "6555502");
        bank.addUser(john);
        Account johnAcc = new Account(1000, "2055556");
        bank.addAccountToUser("6555502", johnAcc);
        User martin = new User("Martin", "6555503");
        bank.addUser(martin);
        Account martinAcc = new Account(500, "3055556");
        bank.addAccountToUser("6555503", martinAcc);
        boolean result = bank.transferMoney("6555502", "2055556", "6555503", "3055556", 1200);
        assertThat(result, is(false));
    }
    /**
     * тест на возможность переслать с одного аккаунта пользователя на другой.
     */
    @Test
    public void whenUserHasTwoAccountsThenTransferFromOneToOther() {
        Bank bank = new Bank();
        User john = new User("John", "6555502");
        bank.addUser(john);
        Account johnAcc1 = new Account(1000, "2055556");
        bank.addAccountToUser(john.getPassport(), johnAcc1);
        Account johnAcc2 = new Account(500, "3055556");
        bank.addAccountToUser(john.getPassport(), johnAcc2);
        assertThat(bank.transferMoney(john.getPassport(), johnAcc1.getRequisites(), john.getPassport(), johnAcc2.getRequisites(), 500), is(true));
    }

    /**
     * тест на невозможность переслать на второй аккаунт пользователя сумму большую, чем есть на первом аккаунте.
     */
    @Test
    public void whenUserHasNotEnoughValueOnSrcAccountThenTransferFalse() {
        Bank bank = new Bank();
        User john = new User("John", "6555502");
        bank.addUser(john);
        Account johnAcc1 = new Account(500, "2055556");
        bank.addAccountToUser(john.getPassport(), johnAcc1);
        Account johnAcc2 = new Account(500, "3055556");
        bank.addAccountToUser(john.getPassport(), johnAcc2);
        assertThat(bank.transferMoney(john.getPassport(), johnAcc1.getRequisites(), john.getPassport(), johnAcc2.getRequisites(), 600), is(false));
    }
}