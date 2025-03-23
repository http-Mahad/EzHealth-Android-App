package com.hasnain.usermoduleupdated.helper

import android.util.Log
import com.google.ai.client.generativeai.GenerativeModel
import com.hasnain.usermoduleupdated.Constant
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object ChatbotHelper {
    private val generativeModel = GenerativeModel(
        modelName = "gemini-1.5-flash",
        apiKey = Constant.GEMINI_API_KEY
    )

//    suspend fun getHealthGuidance(prompt: String): String {
//        val healthPrompt = "You are a health guidance assistant. Provide accurate and safe advice: $prompt"
//        return withContext(Dispatchers.IO) {
//            try {
//                val response = generativeModel.generateContent(healthPrompt)
//                response.text ?: "Sorry, I couldn't generate a response."
//            } catch (e: Exception) {
//                "Error: ${e.message}"
//            }
//        }
//    }
suspend fun getHealthGuidance(prompt: String): String {
    val healthPrompt = "You are a health guidance assistant. Provide accurate and safe advice: $prompt"
    return withContext(Dispatchers.IO) {
        try {
            val response = generativeModel.generateContent(healthPrompt)
            // Log the raw response
            Log.d("API_RESPONSE", response.toString())

            // Safely access the text field
            response.text ?: "Sorry, I couldn't generate a response."
        } catch (e: Exception) {
            // Log the exception
            Log.e("API_ERROR", "Error: ${e.message}")
            "Error: ${e.message}"
        }
    }
}

}