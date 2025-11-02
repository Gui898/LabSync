package com.labSync.LabSync.controller;

import com.labSync.LabSync.models.Favorite;
import com.labSync.LabSync.service.FavoriteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favorite")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class FavoriteController implements ProtocolMethods<Favorite>{

    FavoriteService favoriteService;

    public FavoriteController(FavoriteService favoriteService){
        this.favoriteService = favoriteService;
    }

    @Override
    @PostMapping
    public ResponseEntity<Favorite> post(@RequestBody Favorite favorite) {
        Favorite fav = favoriteService.addFavorite(favorite);
        return ResponseEntity.status(201).body(fav);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        favoriteService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{idPost}/{idUser}")
    public ResponseEntity<Void> deleteByPostAndUserId(
            @PathVariable long idPost, @PathVariable long idUser){
        favoriteService.deleteByPostAndUserId(idPost, idUser);
        return ResponseEntity.noContent().build();
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Favorite> put(@PathVariable long id, @RequestBody Favorite favorite) {
        Favorite edited = favoriteService.updateFavorite(favorite);
        return ResponseEntity.status(201).body(edited);
    }

    @Override
    @PatchMapping("/{id}")
    public ResponseEntity<Favorite> patch(@PathVariable long id, @RequestBody Favorite favorite) {
        Favorite edited = favoriteService.updateFavorite(favorite);
        return ResponseEntity.status(201).body(edited);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Favorite> getById(@PathVariable long id) {
        return ResponseEntity.ok(favoriteService.getFavoriteById(id));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<Favorite>> getAllByUserId(@PathVariable long id){
        return ResponseEntity.ok(favoriteService.getAllFavoritesByUserId(id));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<Favorite>> getAll() {
        return ResponseEntity.ok(favoriteService.getAllFavorites());
    }
}
