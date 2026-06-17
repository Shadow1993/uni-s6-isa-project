package rs.ac.singidunum.novisad.isaproject2023270048.models;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserPrincipal implements UserDetails {

	private static final long serialVersionUID = -7736587976339497382L;
	
	private UserModel user;

    public UserPrincipal(UserModel user){
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getAssignedRoles().stream().map(assignedRole -> new SimpleGrantedAuthority(assignedRole.getRole().getName()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
    	return user.getActive();
    }

    @Override
    public boolean isAccountNonLocked() {
    	return user.getActive();
    }

    @Override
    public boolean isCredentialsNonExpired() {
    	return user.getActive();
    }

    @Override
    public boolean isEnabled() {
    	return user.getActive();
    }
}
