package br.com.ohgestor.msadmin.api.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EstabelecimentoComercial {
//    SUP("Supermercado", Segmento.VAREJO),
    PAD("Padaria", Segmento.ALIMENTACAO),
    RES("Restaurante", Segmento.ALIMENTACAO),
    LAN("Lanchonete", Segmento.ALIMENTACAO),
    LRO("Loja de Roupas", Segmento.VAREJO),
    FAR("Farmácia", Segmento.VAREJO),
    MER("Mercado", Segmento.VAREJO),
//    SHC("Shopping Center", Segmento.VAREJO),
    PCO("Posto de Combustível", Segmento.VAREJO),
    BAR("Bar", Segmento.ALIMENTACAO),
    DBE("Deposito de Bebidas", Segmento.ALIMENTACAO),
//    HOT("Hotel", Segmento.HOSPEDAGEM),
//    CLI("Clínica", Segmento.SAÚDE),
//    ACA("Academia", Segmento.SAÚDE),
    LEL("Loja de Eletrônicos", Segmento.VAREJO),
    LIV("Livraria", Segmento.VAREJO),
    CAB("Cabeleireiro", Segmento.BELEZA),
    PET("Pet Shop", Segmento.VETERINARIO),
    LMO("Loja de Móveis", Segmento.VAREJO),
    QUI("Quiosque", Segmento.VAREJO),
//    DIS("Distribuidora", Segmento.ATACADO),
//    VAU("Venda de Automóveis", Segmento.VAREJO),
    OME("Oficina Mecânica", Segmento.SERVIÇOS),
    BJO("Banca de Jornal", Segmento.VAREJO),
//    LCO("Loja de Conveniência", Segmento.VAREJO),
//    PAP("Papelaria", Segmento.VAREJO),
//    EFO("Estúdio de Fotografia", Segmento.SERVIÇOS),
//    AVI("Agência de Viagens", Segmento.SERVIÇOS),
//    FAB("Fábrica", Segmento.INDUSTRIA),
//    AAR("Ateliê de Arte", Segmento.ARTES),
    LMC("Loja de Materiais de Construção", Segmento.VAREJO),
//    CSH("Casa de Shows", Segmento.ENTRETENIMENTO),
//    QSO("Quiosque de Sorvete", Segmento.ALIMENTACAO),
//    CAF("Cafeteria", Segmento.ALIMENTACAO),
//    LIN("Loja de Informática", Segmento.VAREJO),
//    CFP("Centro de Formação Profissional", Segmento.EDUCACAO),
    LBR("Loja de Brinquedos", Segmento.VAREJO),
    LPA("Livraria e Papelaria", Segmento.VAREJO),
    LPN("Loja de Produtos Naturais", Segmento.VAREJO),
    CAU("Centro Automotivo", Segmento.SERVIÇOS),
    LAE("Loja de Artigos Esportivos", Segmento.VAREJO);

    private final String nome;
    private final Segmento segmento;
}
