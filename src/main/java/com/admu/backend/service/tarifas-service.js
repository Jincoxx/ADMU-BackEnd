// Servicio para obtener tarifas desde la API de Spring Boot
const obtenerTarifasDesdeAPI = async () => {
  try {
    const response = await fetch('http://localhost:8080/api/tarifas');
    if (!response.ok) {
      throw new Error('Error al obtener tarifas');
    }
    const tarifas = await response.json();
    return tarifas;
  } catch (error) {
    console.error('Error al obtener tarifas:', error);
    return null;
  }
};

// Función para formatear las tarifas obtenidas de la API
const formatearTarifasParaChatbot = (tarifas) => {
  if (!tarifas || tarifas.length === 0) {
    return "No se pudieron cargar las tarifas en este momento.";
  }
  
  let texto = "Información sobre tarifas del sistema ADMU:\\n\\n";
  
  tarifas.forEach(tarifa => {
    if (tarifa.tipo === 'general') {
      texto += `• Tarifa general: ${tarifa.tarifa}\\n`;
    } else if (tarifa.tipo === 'estudiantes') {
      texto += `• Tarifa estudiantes (${tarifa.condicion}): ${tarifa.tarifa}\\n`;
    }
  });
  
  // Buscar información sobre método de pago
  const metodoPago = tarifas.find(t => t.tipo === 'metodo_pago');
  if (metodoPago) {
    texto += `\\nMétodo de pago:\\n• ${metodoPago.descripcion}\\n`;
  } else {
    texto += "\\nMétodo de pago:\\n• Efectivo directamente al conductor\\n";
  }
  
  texto += "\\n¿Necesitas más información sobre tarifas?";
  
  return texto;
};

