package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.VueloInternacional;
import co.edu.unbosque.model.VueloInternacionalDTO;
import co.edu.unbosque.model.VueloNacional;
import co.edu.unbosque.model.VueloNacionalDTO;

/**
 * Clase responsable de la conversión entre entidades y sus respectivos Data
 * Transfer Objects (DTO). Contiene métodos para convertir entre los objetos
 * VueloInternacional y VueloInternacionalDTO, así como entre VueloNacional y
 * VueloNacionalDTO.
 * 
 * @author Emmanuel
 * @version 1.0
 * @since 2024-09-24
 */
public class DataMapper {

	/**
	 * Convierte un VueloInternacionalDTO en un VueloInternacional.
	 *
	 * @param dto Objeto VueloInternacionalDTO que se va a convertir.
	 * @return Un objeto VueloInternacional correspondiente.
	 */
	public static VueloInternacional vueloInternacionalDTOToVueloInternacional(VueloInternacionalDTO dto) {
		VueloInternacional entity = new VueloInternacional(dto.getDestino(), dto.getCompanyInCharge(),
				dto.getNumPassengers(), dto.getCaptain(), dto.getSecondInCommand(), dto.getArrivalTime(),
				dto.getDepartureTime(), dto.getGas(), dto.isRequiereVisa());
		return entity;
	}

	/**
	 * Convierte un VueloInternacional en un VueloInternacionalDTO.
	 *
	 * @param entity Objeto VueloInternacional que se va a convertir.
	 * @return Un objeto VueloInternacionalDTO correspondiente.
	 */
	public static VueloInternacionalDTO vueloInternacionalToVueloInternacionalDTO(VueloInternacional entity) {
		VueloInternacionalDTO dto = new VueloInternacionalDTO(entity.getDestino(), entity.getCompanyInCharge(),
				entity.getNumPassengers(), entity.getCaptain(), entity.getSecondInCommand(), entity.getArrivalTime(),
				entity.getDepartureTime(), entity.getGas(), entity.isRequiereVisa());
		return dto;
	}

	/**
	 * Convierte una lista de VueloInternacionalDTO en una lista de
	 * VueloInternacional.
	 *
	 * @param dtoList Lista de objetos VueloInternacionalDTO que se van a convertir.
	 * @return Una lista de objetos VueloInternacional correspondiente.
	 */
	public static ArrayList<VueloInternacional> listaVInternacionalesDTOToListaVuelosInternacionales(
			ArrayList<VueloInternacionalDTO> dtoList) {
		ArrayList<VueloInternacional> entityList = new ArrayList<>();

		for (VueloInternacionalDTO dto : dtoList) {
			entityList.add(new VueloInternacional(dto.getDestino(), dto.getCompanyInCharge(), dto.getNumPassengers(),
					dto.getCaptain(), dto.getSecondInCommand(), dto.getArrivalTime(), dto.getDepartureTime(),
					dto.getGas(), dto.isRequiereVisa()));
		}
		return entityList;
	}

	/**
	 * Convierte una lista de VueloInternacional en una lista de
	 * VueloInternacionalDTO.
	 *
	 * @param entityList Lista de objetos VueloInternacional que se van a convertir.
	 * @return Una lista de objetos VueloInternacionalDTO correspondiente.
	 */
	public static ArrayList<VueloInternacionalDTO> listaVInternacionalesToListaVuelosInternacionalesDTO(
			ArrayList<VueloInternacional> entityList) {
		ArrayList<VueloInternacionalDTO> dtoList = new ArrayList<>();
		for (VueloInternacional entity : entityList) {
			dtoList.add(new VueloInternacionalDTO(entity.getDestino(), entity.getCompanyInCharge(),
					entity.getNumPassengers(), entity.getCaptain(), entity.getSecondInCommand(),
					entity.getArrivalTime(), entity.getDepartureTime(), entity.getGas(), entity.isRequiereVisa()));
		}
		return dtoList;
	}

	/**
	 * Convierte un VueloNacionalDTO en un VueloNacional.
	 *
	 * @param dto Objeto VueloNacionalDTO que se va a convertir.
	 * @return Un objeto VueloNacional correspondiente.
	 */
	public static VueloNacional vueloNacionalDTOToVueloNacional(VueloNacionalDTO dto) {
		VueloNacional entity = new VueloNacional(dto.getDestino(), dto.getCompanyInCharge(), dto.getNumPassengers(),
				dto.getCaptain(), dto.getSecondInCommand(), dto.getArrivalTime(), dto.getDepartureTime(), dto.getGas(),
				dto.isEsTurbina(), dto.isEsHelice());
		return entity;
	}

	/**
	 * Convierte un VueloNacional en un VueloNacionalDTO.
	 *
	 * @param entity Objeto VueloNacional que se va a convertir.
	 * @return Un objeto VueloNacionalDTO correspondiente.
	 */
	public static VueloNacionalDTO vueloNacionalToVueloNacionalDTO(VueloNacional entity) {
		VueloNacionalDTO dto = new VueloNacionalDTO(entity.getDestino(), entity.getCompanyInCharge(),
				entity.getNumPassengers(), entity.getCaptain(), entity.getSecondInCommand(), entity.getArrivalTime(),
				entity.getDepartureTime(), entity.getGas(), entity.isEsTurbina(), entity.isEsHelice());
		return dto;
	}

	/**
	 * Convierte una lista de VueloNacionalDTO en una lista de VueloNacional.
	 *
	 * @param dtoList Lista de objetos VueloNacionalDTO que se van a convertir.
	 * @return Una lista de objetos VueloNacional correspondiente.
	 */
	public static ArrayList<VueloNacional> listaVuelosNacionalesDTOToListaVuelosNacionales(
			ArrayList<VueloNacionalDTO> dtoList) {
		ArrayList<VueloNacional> entityList = new ArrayList<>();

		for (VueloNacionalDTO dto : dtoList) {
			entityList.add(new VueloNacional(dto.getDestino(), dto.getCompanyInCharge(), dto.getNumPassengers(),
					dto.getCaptain(), dto.getSecondInCommand(), dto.getArrivalTime(), dto.getDepartureTime(),
					dto.getGas(), dto.isEsTurbina(), dto.isEsHelice()));
		}
		return entityList;
	}

	/**
	 * Convierte una lista de VueloNacional en una lista de VueloNacionalDTO.
	 *
	 * @param entityList Lista de objetos VueloNacional que se van a convertir.
	 * @return Una lista de objetos VueloNacionalDTO correspondiente.
	 */
	public static ArrayList<VueloNacionalDTO> listaVuelosNacionalesToListaVuelosNacionalesDTO(
			ArrayList<VueloNacional> entityList) {
		ArrayList<VueloNacionalDTO> dtoList = new ArrayList<>();

		for (VueloNacional entity : entityList) {
			dtoList.add(
					new VueloNacionalDTO(entity.getDestino(), entity.getCompanyInCharge(), entity.getNumPassengers(),
							entity.getCaptain(), entity.getSecondInCommand(), entity.getArrivalTime(),
							entity.getDepartureTime(), entity.getGas(), entity.isEsTurbina(), entity.isEsHelice()));
		}
		return dtoList;
	}
}
