package com.Rivas.chatbot;

import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView messagesTextView;
    EditText inputEditText;
    Button sendButton;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        messagesTextView = findViewById(R.id.messagesTextView);
        inputEditText = findViewById(R.id.inputEditText);
        sendButton = findViewById(R.id.sendButton);
        //Una accion cuando se le haga click al boton
        messagesTextView.append(Html.fromHtml("<p>Bienvenido, ingrese una de las siguiente opciones:</p>"));
        messagesTextView.append(Html.fromHtml("<p>1 Sobre Universidad</p>"));
        messagesTextView.append(Html.fromHtml("<p>2 Beneficios de ser Estudiante</p>"));
        messagesTextView.append(Html.fromHtml("<p>3 Talleres Extracurriculares</p>"));
        messagesTextView.append(Html.fromHtml("<p>4 Preguntas Frecuentes</p>"));
        messagesTextView.append(Html.fromHtml("<p>5 Noticias</p>"));
        sendButton.setOnClickListener(view -> {
            String input = inputEditText.getText().toString();//Almacenamos la cadena de entrada
            messagesTextView.append(Html.fromHtml("<p><b>Tu:</b>"+ input  + "</p>"));
            inputEditText.setText("");//Limpiamos el edittext
            switch (input){
                case "1":
                    messagesTextView.append(Html.fromHtml("<p>Misión:</p>"));
                    messagesTextView.append(Html.fromHtml("<p>Formar profesionales competentes y éticos, con capacidad para la investigación e innovación generando conocimiento científico, tecnológico y humanístico, contribuyendo al desarrollo sostenible de la región y del país.</p>"));
                    messagesTextView.append(Html.fromHtml("<p>Rector de la Universidad:</p>"));
                    messagesTextView.append(Html.fromHtml("<p>Dr. Rohel Sánchez Sánchez</p>"));
                    break;
                case "2":
                    messagesTextView.append(Html.fromHtml("<p>-Talleres Extracurriculares</p>"));
                    messagesTextView.append(Html.fromHtml("<p>-Comedor Universitario</p>"));
                    messagesTextView.append(Html.fromHtml("<p>-Servicios Médicos</p>"));
                    messagesTextView.append(Html.fromHtml("<p>-Apoyo en caso de pobreza extrema y falta de recursos moderado</p>"));
                    messagesTextView.append(Html.fromHtml("<p>-Tutoría</p>"));
                    break;
                case "3":
                    messagesTextView.append(Html.fromHtml("<p>Talleres Extracurriculares:</p>"));
                    messagesTextView.append(Html.fromHtml("<p>Un estudiante universitario no solo se desarrolla en el ámbito técnico, sino que también, es explorador de diversas artes y habilidades que complementen y mejoren su humanismo</p>"));
                    messagesTextView.append(Html.fromHtml("<p>Reglas:</p>"));
                    messagesTextView.append(Html.fromHtml("<p>El estudiante puede ingresar a los talleres extracurriculares cada vez que se habiliten por la Oficina de Arte y Deportes, son necesarios una cantidad de 6 talleres extracurriculares para graduarse, el mal desempeño en estos traerá sanciones cada vez más fuertes</p>"));
                    messagesTextView.append(Html.fromHtml("<p>Lista de talleres Extracurriculares:</p>"));
                    messagesTextView.append(Html.fromHtml("<p>      ...(Coming Soon ... Insertar aquí talleres extracurriculares... )</p>"));
                    break;
                case "4":
                    messagesTextView.append(Html.fromHtml("<p>¿Dónde pago los derechos de trámites administrativos?</p>"));
                    messagesTextView.append(Html.fromHtml("<p>¿Cómo se canjean los vouchers por Boleta de la UNSA?</p>"));
                    messagesTextView.append(Html.fromHtml("<p>¿Cuáles son los montos de pago de derechos administrativos?</p>"));
                    messagesTextView.append(Html.fromHtml("<p>¿Cómo se presentan documentos por mesa de partes?</p>"));
                    messagesTextView.append(Html.fromHtml("<p>¿Cómo saco mi correo institucional si soy un alumno antiguo?</p>"));
                    messagesTextView.append(Html.fromHtml("<p>*IMPORTANTE: Todo trámite administrativo debe realizarse con el correo institucional</p>"));
                    break;
                case "5":
                    messagesTextView.append(Html.fromHtml("<p>-UNSA asumió la Vicepresidencia del Consejo de Rectores por la Integración de la Subregión Centro Oeste de Sudamérica CRISCOS</p>"));
                    messagesTextView.append(Html.fromHtml("<p>-Más de medio millón de soles invirtió la UNSA en la recuperación e implementación de espacios deportivos</p>"));
                    messagesTextView.append(Html.fromHtml("<p>-Facultad de Administración de la UNSA será modelo de emprendimiento</p>"));
                    messagesTextView.append(Html.fromHtml("<p>-UNSA construye moderna infraestructura para filial de Camaná</p>"));
                    break;
                default:
                    messagesTextView.append(Html.fromHtml("<p>Interesante pregunta, lamento no tener la respuesta, mi creador necesita actualizarme, por ahora puedes escribir los números correspondientes a estas acciones:</p>"));
                    messagesTextView.append(Html.fromHtml("<p>1 Sobre Universidad</p>"));
                    messagesTextView.append(Html.fromHtml("<p>2 Beneficios de ser Estudiante</p>"));
                    messagesTextView.append(Html.fromHtml("<p>3 Talleres Extracurriculares</p>"));
                    messagesTextView.append(Html.fromHtml("<p>4 Preguntas Frecuentes</p>"));
                    messagesTextView.append(Html.fromHtml("<p>5 Noticias</p>"));
                    break;
            }
        });
    }
}