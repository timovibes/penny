package com.example.penny.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun TermsOfServiceScreen(
    onBackClick: () -> Unit // NAVIGATION: wired in NavGraph to popBackStack()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {

        // ─── TOP BAR ──────────────────────────────────────────────────────────
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { onBackClick() }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Go back"
                )
            }
            Text(
                text = "Terms of Service",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
        }

        HorizontalDivider()
        // ──────────────────────────────────────────────────────────────────────


        // ─── SCROLLABLE CONTENT ───────────────────────────────────────────────
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            Text(
                text = "Last updated: May 2025",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            SectionTitle("1. Acceptance of Terms")
            SectionBody(
                "By creating an account and using Penny, you agree to be bound by these Terms of Service. " +
                        "If you do not agree to these terms, please do not use the app."
            )

            SectionTitle("2. What Penny Does")
            SectionBody(
                "Penny is a personal finance management app that helps you track your income, expenses, " +
                        "and financial goals. Penny does not provide financial advice. Any insights shown in the app " +
                        "are for informational purposes only and should not be treated as professional financial guidance."
            )

            SectionTitle("3. Your Account")
            SectionBody(
                "You are responsible for keeping your account credentials secure. Do not share your password " +
                        "with anyone. You are responsible for all activity that happens under your account. " +
                        "If you suspect unauthorized access, contact us immediately."
            )

            SectionTitle("4. Acceptable Use")
            SectionBody(
                "You agree not to use Penny to:\n\n" +
                        "• Enter false or misleading financial information\n" +
                        "• Attempt to reverse engineer or tamper with the app\n" +
                        "• Use the app for any unlawful purpose\n" +
                        "• Attempt to gain unauthorized access to other users' data"
            )

            SectionTitle("5. Data and Privacy")
            SectionBody(
                "Your financial data is stored securely on your device and in our cloud systems. " +
                        "We do not sell your personal or financial data to third parties. " +
                        "Please read our Privacy Policy for full details on how we handle your data."
            )

            SectionTitle("6. Termination")
            SectionBody(
                "We reserve the right to suspend or terminate your account if you violate these terms. " +
                        "You may also delete your account at any time from the app settings."
            )

            SectionTitle("7. Changes to Terms")
            SectionBody(
                "We may update these terms from time to time. We will notify you of significant changes " +
                        "through the app. Continued use of Penny after changes means you accept the updated terms."
            )

            SectionTitle("8. Contact")
            SectionBody(
                "If you have any questions about these terms, contact us at support@pennyapp.com"
            )

        }
        // ──────────────────────────────────────────────────────────────────────
    }
}