package duy.nguyen.lti.core.common;

public enum LTIRole {
    // System roles
    ACCOUNT_ADMIN("http://purl.imsglobal.org/vocab/lis/v2/system/person#AccountAdmin"),
    CREATOR("http://purl.imsglobal.org/vocab/lis/v2/system/person#Creator"),
    SYS_ADMIN("http://purl.imsglobal.org/vocab/lis/v2/system/person#SysAdmin"),
    SYS_SUPPORT("http://purl.imsglobal.org/vocab/lis/v2/system/person#SysSupport"),
    USER("http://purl.imsglobal.org/vocab/lis/v2/system/person#User"),

    // Institution roles
    INSTITUTION_ADMINISTRATOR("http://purl.imsglobal.org/vocab/lis/v2/institution/person#Administrator"),
    FACULTY("http://purl.imsglobal.org/vocab/lis/v2/institution/person#Faculty"),
    GUEST("http://purl.imsglobal.org/vocab/lis/v2/institution/person#Guest"),
    NONE("http://purl.imsglobal.org/vocab/lis/v2/institution/person#None"),
    OTHER("http://purl.imsglobal.org/vocab/lis/v2/institution/person#Other"),
    STAFF("http://purl.imsglobal.org/vocab/lis/v2/institution/person#Staff"),
    STUDENT("http://purl.imsglobal.org/vocab/lis/v2/institution/person#Student"),
    ALUMNI("http://purl.imsglobal.org/vocab/lis/v2/institution/person#Alumni"),
    INSTITUTION_INSTRUCTOR("http://purl.imsglobal.org/vocab/lis/v2/institution/person#Instructor"),
    INSTITUTION_LEARNER("http://purl.imsglobal.org/vocab/lis/v2/institution/person#Learner"),
    INSTITUTION_MEMBER("http://purl.imsglobal.org/vocab/lis/v2/institution/person#Member"),
    INSTITUTION_MENTOR("http://purl.imsglobal.org/vocab/lis/v2/institution/person#Mentor"),
    OBSERVER("http://purl.imsglobal.org/vocab/lis/v2/institution/person#Observer"),
    PROSPECTIVE_STUDENT("http://purl.imsglobal.org/vocab/lis/v2/institution/person#ProspectiveStudent"),

    // Context roles
    ADMINISTRATOR("http://purl.imsglobal.org/vocab/lis/v2/membership#Administrator"),
    CONTENT_DEVELOPER("http://purl.imsglobal.org/vocab/lis/v2/membership#ContentDeveloper"),
    INSTRUCTOR("http://purl.imsglobal.org/vocab/lis/v2/membership#Instructor"),
    LEARNER("http://purl.imsglobal.org/vocab/lis/v2/membership#Learner"),
    MENTOR("http://purl.imsglobal.org/vocab/lis/v2/membership#Mentor"),
    MANAGER("http://purl.imsglobal.org/vocab/lis/v2/membership#Manager"),
    MEMBER("http://purl.imsglobal.org/vocab/lis/v2/membership#Member"),
    OFFICER("http://purl.imsglobal.org/vocab/lis/v2/membership#Officer"),

    // Soon to deprecate context roles
    OLD_ADMINISTRATOR("Administrator"),
    OLD_CONTENT_DEVELOPER("ContentDeveloper"),
    OLD_INSTRUCTOR("Instructor"),
    OLD_LEARNER("Learner"),
    OLD_MENTOR("Mentor"),
    OLD_MANAGER("Manager"),
    OLD_MEMBER("Member"),
    OLD_OFFICER("Officer")
    ;

    private final String name;

    LTIRole(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static LTIRole from(String name) {
        for (LTIRole role: values()) {
            if (role.getName().equals(name)) {
                return role;
            }
        }
        return  null;
    }
}
