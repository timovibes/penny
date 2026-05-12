package com.example.penny.ui.screens

import android.R.attr.text
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.TextObfuscationMode
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.rounded.AccountBalanceWallet
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.penny.R
import java.nio.file.WatchEvent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue



@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    onLoginClick: () -> Unit,
    onTermsClick: () -> Unit,
    onPrivacyClick: () -> Unit

    /*
     * VIEWMODEL HOOKUP (future):
     *   uiState: SignUpUiState,
     *   onNameChange: (String) -> Unit,
     *   onEmailChange: (String) -> Unit,
     *   onPasswordChange: (String) -> Unit,
     *   onCheckedChange: (Boolean) -> Unit,
     *   onSignUpClick: () -> Unit,
     *   onLoginClick: () -> Unit,
     */

) {

    // ─── LOCAL PLACEHOLDER STATES ──────────────────────────────────────────────
    // Switched from rememberTextFieldState() to plain String state.
    // This API (value + onValueChange) works with singleLine, visualTransformation,
    // and is also the easiest to swap with ViewModel state later.

    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    // Controls whether the password is shown or hidden
    var passwordVisible by remember { mutableStateOf(false) }

    // Controls the Terms & Conditions checkbox
    var isChecked by remember { mutableStateOf(false) }
    // ──────────────────────────────────────────────────────────────────────────


    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // ─── HEADER ───────────────────────────────────────────────────────────
        Column(
            verticalArrangement = Arrangement.spacedBy(6.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(bottom = 32.dp)
        ) {
            Text(
                text = "Start your journey with us!",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Text(
                text = "Manage your finances with ease",
                style = MaterialTheme.typography.titleMedium,
                fontStyle = FontStyle.Italic,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        // ──────────────────────────────────────────────────────────────────────


        // ─── FORM CARD ────────────────────────────────────────────────────────
        Card(
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                // ── FULL NAME FIELD ──────────────────────────────────────────
                // VIEWMODEL HOOKUP:
                //   value = uiState.name,
                //   onValueChange = { onNameChange(it) }
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text("Full name") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary
                        )
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    ),
                    singleLine = true,
                    shape = RoundedCornerShape(12.dp)
                )

                // ── EMAIL FIELD ──────────────────────────────────────────────
                // VIEWMODEL HOOKUP:
                //   value = uiState.email,
                //   onValueChange = { onEmailChange(it) }
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text("Email address") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Email,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary
                        )
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Next
                    ),
                    singleLine = true,
                    shape = RoundedCornerShape(12.dp)
                )

                // ── PASSWORD FIELD ───────────────────────────────────────────
                // VIEWMODEL HOOKUP:
                //   value = uiState.password,
                //   onValueChange = { onPasswordChange(it) }
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text("Password") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Lock,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary)
                    },
                    trailingIcon = {
                        IconButton(onClick = { passwordVisible = !passwordVisible }) {
                            Icon(
                                tint = MaterialTheme.colorScheme.primary,
                                imageVector = if (passwordVisible)
                                    Icons.Default.VisibilityOff
                                else
                                    Icons.Default.Visibility,
                                contentDescription = if (passwordVisible)
                                    "Hide password"
                                else
                                    "Show password"
                            )
                        }
                    },
                    // Hides or shows the password text based on the toggle
                    visualTransformation = if (passwordVisible)
                        VisualTransformation.None
                    else
                        PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Done
                    ),
                    singleLine = true,
                    shape = RoundedCornerShape(12.dp)
                )

                // ── TERMS CHECKBOX ROW ───────────────────────────────────────
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Checkbox(
                        checked = isChecked,
                        onCheckedChange = { isChecked = it }
                        // VIEWMODEL HOOKUP:
                        //   checked = uiState.isTermsAccepted,
                        //   onCheckedChange = { onCheckedChange(it) }
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Row(

                    ) {
                        Text(
                            text = "I agree to the ",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Text(
                            modifier = Modifier.clickable{
                                onTermsClick()
                            },
                            text = "Terms of Service ",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.primary
                        )
                        Text(
                            text = "and ",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Text(
                            modifier = Modifier
                                .clickable{
                                    onPrivacyClick()
                                },
                            text = "Privacy Policy",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }

                }

                // ── SIGN UP BUTTON ───────────────────────────────────────────
                // VIEWMODEL HOOKUP: onClick = { onSignUpClick() }
                Button(
                    onClick = { /* VIEWMODEL HOOKUP: onSignUpClick() */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onPrimary
                    ),
                    enabled = isChecked //the button is greyed out until the checkbox is checeked

                ) {
                    Text(
                        text = "Create Account",
                        style = MaterialTheme.typography.labelLarge
                    )
                }
            }
        }
        // ──────────────────────────────────────────────────────────────────────


        // ─── LOGIN REDIRECT ───────────────────────────────────────────────────
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Already have an account? ",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Text(
                text = "Log in",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.clickable {
                    onLoginClick()
                }
            )
        }
        // ──────────────────────────────────────────────────────────────────────

    }
}