package com.serverside.Api.Reposetries;

import com.serverside.Api.Model.Users_data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UsersRepo extends JpaRepository<Users_data,Long> {

   Optional<Users_data> findByEmail(String email);

   @Transactional
   @Modifying
   @Query("UPDATE Users_data e SET e.amount = e.amount + :x WHERE e.id_code = :id")
   void addTAmount(@Param("id") Long id, @Param("x") Double x);


   @Transactional
   @Modifying
   @Query("UPDATE Users_data e SET e.amount = e.amount - :x WHERE e.id_code = :id")
   void  subtractTAmount(@Param("id") Long id, @Param("x") Double x);

}
