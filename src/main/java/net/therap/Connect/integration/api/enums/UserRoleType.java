package net.therap.Connect.integration.api.enums;

/**
 * @author duity
 * @since 4/19/23
 */

public enum UserRoleType {
    USER("User"),
    ADMIN("Admin");

    private String roleString;


    UserRoleType( String roleString) {
        this.roleString = roleString;
    }

    public String getRoleString() {
        return this.roleString;
    }
}
