package com.example.penny.ui.screens

import androidx.compose.runtime.Composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack

import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun PrivacyPolicyScreen(
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
                text = "Privacy Policy",
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

            SectionTitle("1. Information We Collect")
            SectionBody(
                "When you create an account, we collect:\n\n" +
                        "• Your name and email address\n" +
                        "• A secure password (encrypted, never stored in plain text)\n" +
                        "• Financial data you manually enter such as income, expenses, and budgets\n" +
                        "• Device information for security and crash reporting purposes"
            )

            SectionTitle("2. How We Use Your Information")
            SectionBody(
                "We use your information to:\n\n" +
                        "• Provide and improve the Penny app experience\n" +
                        "• Sync your data across devices\n" +
                        "• Send important account-related notifications\n" +
                        "• Detect and prevent fraud or unauthorized access"
            )

            SectionTitle("3. Google Sign In")
            SectionBody(
                "If you choose to sign in with Google, we receive your name, email address, and profile " +
                        "picture from Google. We do not receive your Google password. " +
                        "Google's own privacy policy applies to information they collect during this process."
            )

            SectionTitle("4. Local Storage")
            SectionBody(
                "Some of your data is stored locally on your device for offline access and performance. " +
                        "This data is protected by your device's security. Clearing the app data or uninstalling " +
                        "the app will remove locally stored data."
            )

            SectionTitle("5. Data Sharing")
            SectionBody(
                "We do not sell, trade, or share your personal or financial data with third parties. " +
                        "The only exceptions are:\n\n" +
                        "• Firebase (Google) — used for authentication and cloud storage\n" +
                        "• Crash reporting tools — to help us fix bugs (no financial data is included)"
            )

            SectionTitle("6. Data Security")
            SectionBody(
                "We use industry-standard security measures including encryption in transit and at rest. " +
                        "However, no system is 100% secure. We encourage you to use a strong password and " +
                        "keep your device secure."
            )

            SectionTitle("7. Your Rights")
            SectionBody(
                "You have the right to:\n\n" +
                        "• Access the data we hold about you\n" +
                        "• Request deletion of your account and data\n" +
                        "• Export your financial data\n\n" +
                        "To exercise any of these rights, contact us at support@pennyapp.com"
            )

            SectionTitle("8. Children's Privacy")
            SectionBody(
                "Penny is not intended for users under the age of 13. We do not knowingly collect " +
                        "data from children. If you believe a child has created an account, please contact us."
            )

            SectionTitle("9. Changes to This Policy")
            SectionBody(
                "We may update this Privacy Policy from time to time. We will notify you of significant " +
                        "changes through the app. Continued use of Penny after changes means you accept the updated policy."
            )

            SectionTitle("10. Contact")
            SectionBody(
                "For any privacy-related questions or concerns, reach us at support@pennyapp.com"
            )

        }
        // ──────────────────────────────────────────────────────────────────────
    }
}