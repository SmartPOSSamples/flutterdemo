package com.example.myapp.myapp


import androidx.annotation.NonNull
import com.example.myapp.myapp.action.PrinterAction
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel

class MainActivity : FlutterActivity() {
    private val CHANNEL = "com.shine.business/print_wizar_pos"


    override fun configureFlutterEngine(@NonNull flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)

        MethodChannel(
            flutterEngine.dartExecutor.binaryMessenger,
            CHANNEL
        ).setMethodCallHandler { call, result ->
            if (call.method == "printWizarPOS") {
                System.out.println("Calling from [printWizarPOS]" + call.arguments())
                PrinterAction().printText(context, call.arguments())
            }
        }
    }
}
