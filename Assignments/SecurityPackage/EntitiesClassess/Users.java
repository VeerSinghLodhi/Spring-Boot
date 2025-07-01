    package com.naukriforsagar.NaukriForSagar.SecurityPackage.EntitiesClassess;

    import jakarta.persistence.*;


    import java.util.Set;

    @Entity
    @Table(name="users1")
    public class Users {

        @Id
        private Long user_id;

        @Column(name="username")
        private String username;

        private String password;

        private boolean enabled;



        @ManyToMany(fetch = FetchType.EAGER)
        @JoinTable(
                name = "user_roles",
                joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "roleid")
        )
        private Set<Roles> roles;


        public Users() {
        }

        public Users(Long user_id, String username, String password, boolean enabled, Set<Roles> roles) {
            this.user_id = user_id;
            this.username = username;
            this.password = password;
            this.enabled = enabled;
            this.roles = roles;
        }



          public Long getUser_id() {
            return user_id;
        }

        public void setUser_id(Long user_id) {
            this.user_id = user_id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        public Set<Roles> getRoles() {
            return roles;
        }

        public void setRoles(Set<Roles> roles) {
            this.roles = roles;
        }

    }
