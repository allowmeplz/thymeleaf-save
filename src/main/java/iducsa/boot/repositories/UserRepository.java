package iducsa.boot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import iducsa.boot.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
