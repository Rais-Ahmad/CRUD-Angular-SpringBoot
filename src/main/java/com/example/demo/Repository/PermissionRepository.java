package com.example.demo.Repository;

import com.example.demo.Model.Permissions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PermissionRepository extends JpaRepository<Permissions, Long> {
	List<Permissions> findAllByIsActiveOrderByCreatedDateDesc(boolean status);

	Optional<Permissions> findByIdAndIsActive(long id, Boolean isActive);

}
