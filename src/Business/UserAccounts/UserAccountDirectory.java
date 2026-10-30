/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccounts;

import Business.Profiles.Profile;

import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 * @author Lee Wang (update)
 */
public class UserAccountDirectory {
    
    ArrayList<UserAccount> useraccountlist;

    /**
     * Constructor.
     */
    public UserAccountDirectory() {
        useraccountlist = new ArrayList();
    }

    /**
     * Adds account.
     */
    public UserAccount newUserAccount(Profile p, String un, String pw) {
        // Profile must not be null.
        if (p == null) {
            throw new IllegalArgumentException("Profile is null");
        }
        // Username must not be null or blank.
        if (un == null || un.trim().isEmpty()) {
            throw new IllegalArgumentException("Username is null");
        }
        // Password must not be null or empty.
        if (pw == null || pw.isEmpty()) {
            throw new IllegalArgumentException("Password is null");
        }
        // Username must be unique.
        if (findUsername(un) != null) {
            throw new IllegalArgumentException("Username exists: " + un);
        }
        
        UserAccount ua = new UserAccount(p, un, pw);
        useraccountlist.add(ua);
        return ua;
    }

    /**
     * Finds account.
     */
    public UserAccount findUserAccount(String id) {
        for (UserAccount ua : useraccountlist) {
            if (ua.isMatch(id)) {
                return ua;
            }
        }
        return null; //not found after going through the whole list
    }

    /**
     * Finds username.
     */
    public UserAccount findUsername(String un) {
        for (UserAccount ua : useraccountlist) {
            if (ua.getUsername().equalsIgnoreCase(un)) {
                return ua;
            }
        }
        return null;
    }

    /**
     * Checks username.
     */
    public boolean isUsernameAvailable(String un) {
        return findUsername(un) == null && !un.trim().isEmpty();
    }

    /**
     * Rename username.
     */
    public boolean renameUsername(UserAccount ua, String un) {
        if (un.equalsIgnoreCase(ua.getUsername())) {
            if (!un.equals(ua.getUsername())) {
                ua.setUsername(un);
            }
            return true;
        }
        if (!isUsernameAvailable(un)) {
            return false;
        }
        ua.setUsername(un);
        return true;
    }

    /**
     * Removes account.
     */
    public void removeUserAccount(UserAccount ua) {
        useraccountlist.remove(ua);
    }

    /**
     * Authenticates user.
     */
    public UserAccount AuthenticateUser(String un, String pw) {
        for (UserAccount ua : useraccountlist) {
            if (ua.IsValidUser(un, pw)) {
                ua.recordActivity();
                return ua;
            }
        }
        return null; //not found after going through the whole list
    }

    /**
     * Gets accounts.
     */
    public ArrayList<UserAccount> getUserAccountList() {
        return useraccountlist;
    }
}
