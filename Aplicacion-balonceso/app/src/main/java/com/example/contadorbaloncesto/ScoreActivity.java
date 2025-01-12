package com.example.contadorbaloncesto;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        TextView tvFinalScore = findViewById(R.id.tv_final_score);
        TextView tvResult = findViewById(R.id.tv_result);
        TextView tvLocal = findViewById(R.id.tv_score_local);
        TextView tvVisit = findViewById(R.id.tv_score_visitor);
        Button btnBackToMain = findViewById(R.id.btn_back_to_main);

        // Obtener puntajes desde el Intent
        int scoreLocal = getIntent().getIntExtra("SCORE_LOCAL", 0);
        int scoreVisitor = getIntent().getIntExtra("SCORE_VISITOR", 0);

        // Mostrar el marcador final
        tvFinalScore.setText("Final Score: " + scoreLocal + " - " + scoreVisitor);
        tvLocal.setText(String.valueOf(scoreLocal)); // Convertir a String
        tvVisit.setText(String.valueOf(scoreVisitor)); // Convertir a String




        // Determinar el resultado
        if (scoreLocal > scoreVisitor) {
            tvResult.setText("Local team Wins!");
        } else if (scoreVisitor > scoreLocal) {
            tvResult.setText("Visitor team Wins!");
        } else {
            tvResult.setText("It was a Draw 😕");
        }

        // Botón para regresar a la pantalla principal
        btnBackToMain.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // Cerrar ScoreActivity
            startActivity(intent);
        });
    }
}
