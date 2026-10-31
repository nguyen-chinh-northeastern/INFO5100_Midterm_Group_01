/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccounts;

import Business.Profiles.Profile;

import java.time.LocalDateTime;

/**
 *
 * @author kal bugrara
 * @author Lee Wang (update)
 */
public class UserAccount {

    Profile profile;
    String username;
    String password;
    boolean active;
    LocalDateTime lastUpdated;
    LocalDateTime lastActivity;

    /**
     * Constructor.
     */
    public UserAccount(Profile profile, String un, String pw) {
        username = un;
        password = pw;
        this.profile = profile;
        active = true;
        lastUpdated = LocalDateTime.now();
        lastActivity = null;
    }

    /**
     * Records update.
     */
    public void recordUpdate() {
        lastUpdated = LocalDateTime.now();
    }

    /**
     * Records activity.
     */
    public void recordActivity() {
        lastActivity = LocalDateTime.now();
    }

    /**
     * Gets person ID.
     */
    public String getPersonId() {
        return profile.getPerson().getPersonId();
    }

    /**
     * Gets login name.
     */
    public String getUserLoginName() {
        return username;
    }

    /**
     * Matches ID.
     */
    public boolean isMatch(String id) {
        return getPersonId().equals(id);
    }

    /**
     * Validates user.
     */
    public boolean IsValidUser(String un, String pw) {
        return username.equalsIgnoreCase(un) && password.equals(pw) && active;
    }

    /**
     * Gets role.
     */
    public String getRole() {
        return profile.getRole();
    }

    /**
     * Gets profile.
     */
    public Profile getAssociatedPersonProfile() {
        return profile;
    }

    /**
     * Gets username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets username.
     */
    protected void setUsername(String username) {
        this.username = username;
        recordUpdate();
    }

    /**
     * Sets password.
     */
    public void setPassword(String password) {
        this.password = password;
        recordUpdate();
    }

    /**
     * Gets active.
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Sets active.
     */
    public void setActive(boolean active) {
        this.active = active;
        recordUpdate();
    }

    /**
     * Gets last updated.
     */
    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    /**
     * Gets last activity.
     */
    public LocalDateTime getLastActivity() {
        return lastActivity;
    }

    /**
     * Gets username.
     */
    @Override
    public String toString() {
        return getUserLoginName();
    }
}
