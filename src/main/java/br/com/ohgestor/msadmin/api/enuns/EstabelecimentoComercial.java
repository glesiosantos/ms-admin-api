package br.com.ohgestor.msadmin.api.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EstabelecimentoComercial {
//    SUP("Supermercado", Segmento.VAREJO),
    PAD("Padaria", Segmento.BEBIDAS_ALIMENTOS),
    RES("Restaurante", Segmento.BEBIDAS_ALIMENTOS),
    LAN("Lanchonete", Segmento.BEBIDAS_ALIMENTOS),
    LRO("Loja de Roupas", Segmento.COMERCIAL_SERVICOS),
    FAR("Farmácia", Segmento.COMERCIAL_SERVICOS),
    MER("Mercado", Segmento.COMERCIAL_SERVICOS),
    BAR("Bar", Segmento.COMERCIAL_SERVICOS),
    DBE("Deposito de Bebidas", Segmento.BEBIDAS_ALIMENTOS),
    LEL("Loja de Eletrônicos", Segmento.COMERCIAL_SERVICOS),
    CAB("Cabeleireiro", Segmento.SAUDE_BELEZA),
    PET("Pet Shop", Segmento.COMERCIAL_SERVICOS),
    LMO("Loja de Móveis", Segmento.COMERCIAL_SERVICOS),
    QUI("Quiosque", Segmento.COMERCIAL_SERVICOS),
    OMC("Oficina Mecânica de Carros", Segmento.MECANICA_AUTO_CENTER),
    OMM("Oficina Mecânica de Motos", Segmento.MECANICA_AUTO_CENTER),
    BJO("Banca de Jornal", Segmento.COMERCIAL_SERVICOS),
    LMC("Loja de Materiais de Construção", Segmento.COMERCIAL_SERVICOS),
//    CSH("Casa de Shows", Segmento.ENTRETENIMENTO),
//    QSO("Quiosque de Sorvete", Segmento.ALIMENTACAO),
//    CAF("Cafeteria", Segmento.ALIMENTACAO),
//    LIN("Loja de Informática", Segmento.VAREJO),
//    CFP("Centro de Formação Profissional", Segmento.EDUCACAO),
    LBR("Loja de Brinquedos", Segmento.COMERCIAL_SERVICOS),
    LPA("Livraria e Papelaria", Segmento.COMERCIAL_SERVICOS),
    LPN("Loja de Produtos Naturais", Segmento.COMERCIAL_SERVICOS),
    CAU("Centro Automotivo", Segmento.COMERCIAL_SERVICOS),
    LAE("Loja de Artigos Esportivos", Segmento.COMERCIAL_SERVICOS);

    private final String nome;
    private final Segmento segmento;
}
