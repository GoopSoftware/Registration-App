package com.dzl.registrationform

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dzl.registrationform.databinding.ActivitySummaryScreenBinding



/*
1. display summary, Welcome firstname, lastname thank you for creating an account
2. display email
    - clickable to send email
3. display number
    - clickable to send text
 */
class SummaryActivity : AppCompatActivity() {

    private lateinit var intentManager: IntentManager
    private lateinit var summary: String

    private lateinit var binding: ActivitySummaryScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySummaryScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        displaySummary()
        displayEmail()
        displayNumber()


    }

    private fun displayNumber() {
        // Purposely set the number to be the user input number to test a pressable textview
        binding.textViewSummaryPhoneNumber.text = "Text us: ${intentManager.phoneNumber}"
        binding.textViewSummaryPhoneNumber.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("smsto: ${intentManager.phoneNumber}")
                putExtra("sms_body", "This is a test of the Android sms feature")
            }
            startActivity(intent)
        }
    }

    private fun displayEmail() {
        // Purposely using the users input number here as well
        binding.textViewSummaryEmail.text = "Email Us: ${intentManager.email}"
        binding.textViewSummaryEmail.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL, intentManager.email)
                putExtra(Intent.EXTRA_SUBJECT, "This is a test of the Android email feature")
            }
            startActivity(intent)
        }
    }

    private fun displaySummary() {
        intentManager = intent.getParcelableExtra<IntentManager>("summary")!!


        fun returnPrefixTitle(): String {
            var title: String = intentManager.title
            return if (title != "None" && title != "Jr.") {
                "$title "
            } else {
                return ""
            }
        }

        fun returnSuffixTitle(): String {
            var title: String = intentManager.title
            if (title == "Jr.") {
                return " $title"
            }
            else {
                return ""
            }
        }

        summary =
            """
            Hi ${returnPrefixTitle()}${intentManager.firstName} ${intentManager.lastName}${returnSuffixTitle()}, 
            
            Thank you for creating an account at Retro Registration Form App. 
            We are happy to have you as a new member of our community.
        """.trimIndent()

        binding.textViewSummaryFirstLastName.text = summary
    }
}