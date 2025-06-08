import { Component } from '@angular/core';
import {Produite} from "../Modele/Produit";
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {NgForm} from "@angular/forms";

@Component({
  selector: 'app-produit',
  templateUrl: './produit.component.html',
  styleUrl: './produit.component.css'
})
export class ProduitComponent {

  produit: any;
  pr!: Produite;
profile :any
  test = {
    idP: "",
    marque: "",
    type: "",
    qte: "",
    prix :""
  }

  constructor(private http: HttpClient, public router: Router) {
  }

  ngOnInit(): void {
    this.fetchProduits();
      this.profile = localStorage.getItem('role');
  }

  fetchProduits(): void {
    this.http.get("http://localhost:8888/PRODUIT-SERVICE/produit")
      .subscribe({
        next: data => {

          this.produit = data
        },
        error: err => {
          console.log(err);
        }
      })


  }
  supprimerClient(idP: number): void {
    console.log(idP);
    this.http.delete(`http://localhost:8888/PRODUIT-SERVICE/produit/${idP}`)
      .subscribe({
        next: () => {
          this.fetchProduits();
        },
        error: (err: any) => {
          console.log(err);
        }
      });
  }
  confirmerSuppression(id: number): void {
    if (confirm('Êtes-vous sûr de vouloir supprimer ce client ?')) {
      this.supprimerClient(id);
    } else {
      console.log('Suppression annulée.');
    }

  }

  postProdui(add:NgForm){
    let valeur= add.value;
    let data = {marque :valeur.marque, type:valeur.type,prix: valeur.prix,qte: valeur.qte}
    this.http.post("http://localhost:8888/PRODUIT-SERVICE/produit", data)
      .subscribe({
        next:value => {
          this.fetchProduits();

        },
        error:err => {
          console.log(err)
        }
      })
  }
  updateProduit(upd: NgForm): void {

    alert("update successful");
    let valeur = upd.value;
    if(valeur.marque==""){
      valeur.marque=this.pr.marque;
    }
    if(valeur.type==""){
      valeur.type=this.pr.type;
    }
    if(valeur.prix=""){
      valeur.prix=this.pr.prix;
    }
    if(valeur.qte==""){
      valeur.qte=this.pr.qte;
    }
    let ce= {marque:valeur.marque, type:valeur.type,prix:valeur.prix, qte:valeur.qte};

    this.http.put(`http://localhost:8888/PRODUIT-SERVICE/produit/${this.pr.idP}`, ce)
      .subscribe({
        next: (value: any) => {
          this.fetchProduits(); //
        },
        error: (err: any) => {
          console.log(err);

        }
      });
  }
  prendre(pro:any){
    this.pr = pro;
    this.test = pro;
  }

}
