package com.projetoNicks.server.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projetoNicks.server.Entities.ClienteEntity;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {


}
