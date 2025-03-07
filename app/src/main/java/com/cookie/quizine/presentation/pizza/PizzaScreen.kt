package com.cookie.quizine.presentation.pizza

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cookie.quizine.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PizzaScreen(modifier: Modifier = Modifier) {
    Scaffold(
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .background(Color(0XFFD7EF7F))
        ) {
            Row(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null,
                        modifier = Modifier.padding(16.dp)
                    )
                    Spacer(Modifier.height(50.dp))
                    Row {
                        Box(
                            modifier = Modifier
                                .padding(16.dp)
                                .background(Color(0XFF647039))
                                .height(32.dp)
                                .width(32.dp)
                        )
                        Text(
                            "Veg Pizza",
                            fontSize = 30.sp,
                            color = Color(0XFF647039),
                            modifier = Modifier.padding(top = 16.dp)
                        )
                    }
                    Text(
                        "Veg Pizza",
                        fontSize = 20.sp,
                        color = Color(0XFF647039),
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(start = 50.dp)
                    )
                }
                Box(
                    modifier = Modifier
                        .offset(x = 30.dp, y = -8.dp)
                        .border(24.dp, Color(0XFF647039), CircleShape)
                        .weight(1f)
                        .clip(shape = CircleShape)
                        .padding(24.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.pizza),
                        contentDescription = null,
                        contentScale = ContentScale.Fit
                    )
                }

            }
            Column(
                modifier = Modifier
                    .weight(3f)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(topStart = 45.dp, topEnd = 45.dp))
                    .background(Color.White)
                    .padding(30.dp)
            ) {
                Text(
                    "Particulars",
                    fontSize = 30.sp,
                    color = Color(0XFF647039)
                )
                Text(
                    "This is a tried and tested recipe, yields the best veg pizza just like in restaurants. Here I have used onion, capsicum, sweet corn in this pizza, you can use any of your favorite toppings like paneer, mushroom, olives ,broccoli and the variations are endless.",
                    fontSize = 20.sp,
                    color = Color(0XFF647039)
                )
                StarComponent(4)
                Spacer(Modifier.height(24.dp))
                Text(
                    "Crust",
                    fontSize = 30.sp,
                    color = Color(0XFF647039)
                )
                Row {
                    OutlinedButton(
                        onClick = {},
                        shape = RoundedCornerShape(20.dp),
                        colors = ButtonColors(
                            containerColor = Color(0XFFD7EF7F),
                            contentColor = Color(0XFF647039),
                            disabledContainerColor = Color(0XFFD7EF7F),
                            disabledContentColor = Color(0XFF647039)
                        ),
                        border = ButtonDefaults.outlinedButtonBorder,
                    ) {
                        Text(
                            "Hand Tossed",
                            fontSize = 16.sp,
                            color = Color(0XFF647039)
                        )
                    }
                    Spacer(Modifier.width(8.dp))
                    OutlinedButton(
                        onClick = {},
                        shape = RoundedCornerShape(20.dp),
                        colors = ButtonColors(
                            containerColor = Color(0XFFD7EF7F),
                            contentColor = Color(0XFF647039),
                            disabledContainerColor = Color(0XFFD7EF7F),
                            disabledContentColor = Color(0XFF647039)
                        )
                    ) {
                        Text(
                            "Cheese-burst",
                            fontSize = 16.sp,
                            color = Color(0XFF647039)
                        )
                    }
                }
                Spacer(Modifier.height(24.dp))
                Text(
                    "Size",
                    fontSize = 30.sp,
                    color = Color(0XFF647039)
                )
                Row {
                    OutlinedButton(
                        onClick = {},
                        shape = RoundedCornerShape(20.dp),
                        colors = ButtonColors(
                            containerColor = Color(0XFFD7EF7F),
                            contentColor = Color(0XFF647039),
                            disabledContainerColor = Color(0XFFD7EF7F),
                            disabledContentColor = Color(0XFF647039)
                        ),
                        border = ButtonDefaults.outlinedButtonBorder,
                    ) {
                        Column {
                            Text(
                                "Regular",
                                fontSize = 16.sp,
                                color = Color(0XFF647039)
                            )
                            Text(
                                "235.0",
                                fontSize = 16.sp,
                                color = Color(0XFF647039)
                            )
                        }
                    }
                    Spacer(Modifier.width(8.dp))
                    OutlinedButton(
                        onClick = {},
                        shape = RoundedCornerShape(20.dp),
                        colors = ButtonColors(
                            containerColor = Color(0XFFD7EF7F),
                            contentColor = Color(0XFF647039),
                            disabledContainerColor = Color(0XFFD7EF7F),
                            disabledContentColor = Color(0XFF647039)
                        ),
                        border = ButtonDefaults.outlinedButtonBorder,
                    ) {
                        Column {
                            Text(
                                "Medium",
                                fontSize = 16.sp,
                                color = Color(0XFF647039)
                            )
                            Text(
                                "265.0",
                                fontSize = 16.sp,
                                color = Color(0XFF647039)
                            )
                        }
                    }
                    Spacer(Modifier.width(8.dp))
                    OutlinedButton(
                        onClick = {},
                        shape = RoundedCornerShape(20.dp),
                        colors = ButtonColors(
                            containerColor = Color(0XFFD7EF7F),
                            contentColor = Color(0XFF647039),
                            disabledContainerColor = Color(0XFFD7EF7F),
                            disabledContentColor = Color(0XFF647039)
                        ),
                        border = ButtonDefaults.outlinedButtonBorder,
                    ) {
                        Column {
                            Text(
                                "Large",
                                fontSize = 16.sp,
                                color = Color(0XFF647039)
                            )
                            Text(
                                "295.0",
                                fontSize = 16.sp,
                                color = Color(0XFF647039)
                            )
                        }
                    }
                }
                Spacer(Modifier.height(10.dp))
                Row {
                    Button(
                        modifier = Modifier,
                        onClick = {},
                        colors = ButtonColors(
                            Color(0XFF647039),
                            contentColor = Color.White,
                            disabledContainerColor = Color(0XFF647039),
                            disabledContentColor = Color.White
                        ),
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                "Add to Cart"
                            )
                            Icon(
                                imageVector = Icons.Default.ArrowForward,
                                contentDescription = null
                            )
                        }
                    }
                    Spacer(Modifier.width(8.dp))
                    Button(
                        modifier = Modifier,
                        onClick = {},
                        colors = ButtonColors(
                            Color(0XFF647039),
                            contentColor = Color.White,
                            disabledContainerColor = Color(0XFF647039),
                            disabledContentColor = Color.White
                        ),
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                "Go to Cart"
                            )
                            Icon(
                                imageVector = Icons.Default.ArrowForward,
                                contentDescription = null
                            )
                        }
                    }
                }

            }
        }
    }
}

@Composable
fun StarComponent(rating: Int) {
    Row(
        modifier = Modifier.padding(start = 16.dp, top = 12.dp)
    ) {
        for (i in 0..4) {
            Icon(
                imageVector = Icons.Filled.Star,
                contentDescription = null,
                tint = if (rating > i) {
                    Color(0XFF647039)
                } else {
                    Color(0XFFD7EF7F)
                }
            )
            Spacer(Modifier.width(4.dp))
        }
    }
}

@Preview
@Composable
private fun PizzaScreenPrev() {
    PizzaScreen()
}