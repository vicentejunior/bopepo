/* 
 * Copyright 2014 JRimum Project
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 * 
 * Created at: 19/01/2014 - 22:26:33
 *
 * ================================================================================
 *
 * Direitos autorais 2014 JRimum Project
 *
 * Licenciado sob a Licença Apache, Versão 2.0 ("LICENÇA"); você não pode 
 * usar esse arquivo exceto em conformidade com a esta LICENÇA. Você pode obter uma 
 * cópia desta LICENÇA em http://www.apache.org/licenses/LICENSE-2.0 A menos que 
 * haja exigência legal ou acordo por escrito, a distribuição de software sob esta 
 * LICENÇA se dará “COMO ESTÁ”, SEM GARANTIAS OU CONDIÇÕES DE QUALQUER TIPO, sejam 
 * expressas ou tácitas. Veja a LICENÇA para a redação específica a reger permissões 
 * e limitações sob esta LICENÇA.
 * 
 * Criado em: 19/01/2014 - 22:26:33 
 * 
 */

package org.jrimum.bopepo.view.info.campo;

import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;

import org.jrimum.bopepo.Boleto;
import org.jrimum.bopepo.excludes.BoletoBuilder;
import org.jrimum.bopepo.view.ResourceBundle;
import org.jrimum.domkee.financeiro.banco.febraban.Banco;
import org.jrimum.domkee.financeiro.banco.febraban.CodigoDeCompensacaoBACEN;
import org.junit.Test;

/**
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L.</a>
 *
 */
public class TestBoletoInfoCampoViewFactory {

	@Test
	public void deve_retornar_implementacao_padrao_para_bancos_nao_suportados(){
		ResourceBundle resourceBundle = new ResourceBundle();
		Boleto boleto = BoletoBuilder.defaultValue();
		boleto.getTitulo().getContaBancaria().setBanco(new Banco(new CodigoDeCompensacaoBACEN(999), "INEXISTENTE"));
				
		BoletoInfoCampoView infoCampo = BoletoInfoCampoViewFactory.create(resourceBundle, boleto); 
		
		assertThat(infoCampo, instanceOf(BoletoInfoViewDefault.class));
	}
}
