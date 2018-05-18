package ru.job4j.bank;

import java.util.*;

/**
 * класс организации банковских переводов.
 * @author Dmitry Ilyshev (dilyshev@mac.com)
 * @version $Id$
 * @since 0.1
 */
public class Bank {
    private Map<User, List<Account>> userAccountList = new TreeMap<>();

    /**
     * метод добавления пользователя.
     * @param user новый пользователь.
     */
    public void addUser(User user) {
        this.userAccountList.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * метод удаления пользователя.
     * @param user удаляемый пользователь.
     */
    public void deleteUser(User user) {
        this.userAccountList.remove(user);
    }

    /**
     * метод проверки наличия пользователя в списке.
     * @param user пользователь
     * @return истина / ложь.
     */
    public boolean containsUser(User user) {
        return this.userAccountList.containsKey(user);
    }
    /**
     * метод добавления счета пользователю.
     * @param passport идентификатор пользователя паспорт.
     * @param account новый счет.
     */
    public void addAccountToUser(String passport, Account account) {
        for (User user: this.userAccountList.keySet()) {
            if (user.getPassport().equals(passport)) {
                this.userAccountList.get(user).add(account);
            }
        }
    }

    /**
     * метод удаления счета у пользователя.
     * @param passport идентификатор пользователя паспорт.
     * @param account удаляемый счет.
     */
    public void deleteAccountFromUser(String passport, Account account) {
        for (User user : this.userAccountList.keySet()) {
            if (user.getPassport().equals(passport)) {
                this.userAccountList.get(user).remove(account);
            }
        }
    }

    /**
     * получить список счетов пользователя.
     * @param passport идентификатор пользователя паспорт.
     * @return userAccountList список счетов пользователя.
     */
    public List<Account> getUserAccounts(String passport) {
        List<Account> userAccounts = new ArrayList<>();
        for (User user : this.userAccountList.keySet()) {
            if (user.getPassport().equals(passport)) {
                userAccounts = this.userAccountList.get(user);
            }
        }
        return userAccounts;
    }

    /**
     * метод определения текущего счета пользователя.
     * @param requisites реквизиты счета.
     * @return current номер текущего счета.
     */
    private Account getActualAccount(String requisites) {
        Account current = new Account();
        for (List<Account> list : this.userAccountList.values()) {
            for (Account account : list) {
                if (account.getRequisites().equals(requisites)) {
                    current = account;
                }
            }
        }
        return current;
    }

    /**
     * метод проверки наличия пользователя по паспорту
     * @param passport номер паспорта.
     * @return истина / ложь.
     */
    public boolean getPassport(String passport) {
        boolean equals = false;
        for (User user : this.userAccountList.keySet()) {
            if (user.getPassport().equals(passport)) {
                equals = true;
            }
        }
        return equals;
    }

    /**
     * метод проверки наличия у пользователя реквизитов.
     * @param requisites реквизиты
     * @return истина / ложь.
     */
    public boolean getRequisites(String requisites) {
        boolean equals = false;
        for (User user : this.userAccountList.keySet()) {
            if (this.userAccountList.get(user).contains(getActualAccount(requisites))) {
                equals = true;
            }
        }
        return equals;
    }

    /**
     * метод передачи средств между счетами.
     * @param srcPassport паспорт отправителя.
     * @param srcRequisite реквизиты отправителя.
     * @param destPassport паспорт получателя.
     * @param dstRequisite реквизиты получателя.
     * @param amount сумма денег для перевода.
     * @return перевод выполнен / нет.
     */
       public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
       return getPassport(srcPassport) && getRequisites(srcRequisite)
               && getPassport(destPassport) && getRequisites(dstRequisite)
               && getActualAccount(srcRequisite).transfer(
                       getActualAccount(dstRequisite), amount);
   }
}
